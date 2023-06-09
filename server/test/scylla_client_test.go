package test

import (
	"fmt"
	"github.com/gocql/gocql"
	"github.com/scylladb/gocqlx/v2"
	"github.com/scylladb/gocqlx/v2/qb"
	"github.com/smartystreets/assertions"
	"testing"
)

func TestCqlx(t *testing.T) {
	cluster := gocql.NewCluster("localhost:9042")
	cluster.Keyspace = "example"
	cluster.AuthProvider = func(h *gocql.HostInfo) (gocql.Authenticator, error) {
		return gocql.PasswordAuthenticator{
			Username: "cassandra",
			Password: "cassandra",
		}, nil
	}
	session, err := gocqlx.WrapSession(cluster.CreateSession())
	if err != nil {
		t.Fatal(err)
	}

	fmt.Println("create example keyspace")
	err = session.ExecStmt("create keyspace if not exists example with replication = {'class': 'SimpleStrategy', 'replication_factor': 1}")
	if err != nil {
		panic(err)
	}

	fmt.Println("create tweets table")
	err = session.ExecStmt("create table if not exists example.person (id int, first_name text, last_name text, primary key ( id ) ) ")
	if err != nil {
		panic(err)
	}

	q := qb.Insert("example.person").Columns("id", "first_name", "last_name").Query(session).Bind(1, "mahmoud", "kheyrati")
	if err := q.Exec(); err != nil {
		panic(err)
	}

	s := qb.Select("example.person").Where(qb.Eq("id")).Limit(1).Query(session).Bind(1)
	var (
		id        int
		firstName string
		lastName  string
	)

	iter := s.Iter()
	iter.Scan(&id, &firstName, &lastName)
	//	scanner.Next()
	//err = scanner.Scan()
	if err != nil {
		panic(err)
	}
	assertions.ShouldEqual(id, 1)
	assertions.ShouldEqual(firstName, "mahmoud")
	assertions.ShouldEqual(lastName, "kheyrati")

}
