package db

import (
	"github.com/gocql/gocql"
	"time"
)

type AdminCommandLog struct {
	DeviceID       string
	Command        string
	AdminUsername  string
	CommandPayload string
	Timestamp      time.Time
}

type AdminCommandLogRepo struct {
	session *gocql.Session
}

func (a *AdminCommandLogRepo) Insert(adminCommandLog AdminCommandLog) error {
	// Construct the INSERT query
	query := "INSERT INTO attendance_system.admin_commands_log (device_id, command, admin_username, command_payload, timestamp) VALUES (?, ?, ?, ?, ?)"

	// Execute the query with the given admin command log data
	err := a.session.Query(query, adminCommandLog.DeviceID, adminCommandLog.Command, adminCommandLog.AdminUsername, adminCommandLog.CommandPayload, adminCommandLog.Timestamp).Exec()
	return err
}
