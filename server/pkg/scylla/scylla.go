package scylla

import (
	"fmt"
	"github.com/gocql/gocql"
)

type Config struct {
	Host            string
	Port            int
	Username        string
	Password        string
	DefaultKeyspace string
}

func NewScyllaSession(config Config) (*gocql.Session, error) {
	cluster := gocql.NewCluster(fmt.Sprintf("%s:%d", config.Host, config.Port))
	cluster.Keyspace = config.DefaultKeyspace
	cluster.AuthProvider = func(h *gocql.HostInfo) (gocql.Authenticator, error) {
		return gocql.PasswordAuthenticator{
			Username: config.Username,
			Password: config.Password,
		}, nil
	}
	clusterSession, err := cluster.CreateSession()
	//session, err := gocqlx.WrapSession(cluster.CreateSession())
	return clusterSession, err
}
