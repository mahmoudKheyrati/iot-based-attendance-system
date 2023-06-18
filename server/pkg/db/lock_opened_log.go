package db

import (
	"github.com/gocql/gocql"
	"time"
)

type LockOpenedLog struct {
	DeviceID            string
	ServerTimestamp     time.Time
	TimeAfterStartupSec int
}

type LockOpenedLogRepo struct {
	session *gocql.Session
}

func NewLockOpenedLogRepo(session *gocql.Session) *LockOpenedLogRepo {
	return &LockOpenedLogRepo{session: session}
}

func (l *LockOpenedLogRepo) Insert(lockOpenedLog LockOpenedLog) error {
	// Construct the INSERT query
	query := "INSERT INTO attendance_system.lock_opened_log (device_id, server_timestamp, time_after_startup_sec) VALUES (?, ?, ?)"

	// Execute the query with the given lock opened log data
	err := l.session.Query(query, lockOpenedLog.DeviceID, lockOpenedLog.ServerTimestamp, lockOpenedLog.TimeAfterStartupSec).Exec()
	return err
}
