package scylla

import (
	"fmt"
	"github.com/gocql/gocql"
	"github.com/scylladb/gocqlx/v2"
)

type Config struct {
	Host            string
	Port            int
	Username        string
	Password        string
	DefaultKeyspace string
}

func NewScyllaSession(config Config) (gocqlx.Session, error) {
	cluster := gocql.NewCluster(fmt.Sprintf("%s:%d", config.Host, config.Port))
	cluster.Keyspace = config.DefaultKeyspace
	cluster.AuthProvider = func(h *gocql.HostInfo) (gocql.Authenticator, error) {
		return gocql.PasswordAuthenticator{
			Username: config.Username,
			Password: config.Password,
		}, nil
	}
	session, err := gocqlx.WrapSession(cluster.CreateSession())
	return session, err
}
