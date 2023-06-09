module server

go 1.20

require (
	github.com/eclipse/paho.mqtt.golang v1.4.2
	github.com/gocql/gocql v1.4.0
	github.com/scylladb/scylla-go-driver v0.0.0-20221013134735-ce81923df69a
	github.com/smartystreets/assertions v1.13.1
)

replace github.com/gocql/gocql v1.4.0 => github.com/scylladb/gocql v1.10.0

require (
	github.com/golang/snappy v0.0.4 // indirect
	github.com/gorilla/websocket v1.4.2 // indirect
	github.com/hailocab/go-hostpool v0.0.0-20160125115350-e80d13ce29ed // indirect
	github.com/klauspost/compress v1.15.1 // indirect
	github.com/klauspost/cpuid/v2 v2.2.5 // indirect
	github.com/pierrec/lz4/v4 v4.1.14 // indirect
	github.com/scylladb/go-reflectx v1.0.1 // indirect
	github.com/scylladb/gocqlx/v2 v2.8.0 // indirect
	go.uber.org/atomic v1.9.0 // indirect
	golang.org/x/net v0.0.0-20200425230154-ff2c4b7c35a0 // indirect
	golang.org/x/sync v0.0.0-20210220032951-036812b2e83c // indirect
	golang.org/x/sys v0.8.0 // indirect
	gopkg.in/inf.v0 v0.9.1 // indirect
)
