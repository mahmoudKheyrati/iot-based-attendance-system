package scylla

import (
	"fmt"
	"github.com/gocql/gocql"
	"github.com/scylladb/gocqlx/v2"
)

func NewScyllaSession(host string, port int, defaultKeyspace, username, password string) (gocqlx.Session, error) {
	cluster := gocql.NewCluster(fmt.Sprintf("%s:%d", host, port))
	cluster.Keyspace = defaultKeyspace
	cluster.AuthProvider = func(h *gocql.HostInfo) (gocql.Authenticator, error) {
		return gocql.PasswordAuthenticator{
			Username: username,
			Password: password,
		}, nil
	}
	session, err := gocqlx.WrapSession(cluster.CreateSession())
	return session, err
}
