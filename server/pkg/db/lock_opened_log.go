package db

import (
	"github.com/gocql/gocql"
	"time"
)

type LockOpenedLog struct {
	DeviceID            string
	CardUid             string
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
	query := "INSERT INTO attendance_system.lock_opened_log (device_id, card_uid, server_timestamp, time_after_startup_sec) VALUES (?,?, ?, ?)"

	// Execute the query with the given lock opened log data
	err := l.session.Query(query, lockOpenedLog.DeviceID, lockOpenedLog.CardUid, lockOpenedLog.ServerTimestamp, lockOpenedLog.TimeAfterStartupSec).Exec()
	return err
}

func (l *LockOpenedLogRepo) GetByDeviceID(deviceID string) ([]LockOpenedLog, error) {
	// Construct the SELECT query
	query := "SELECT device_id, card_uid, server_timestamp, time_after_startup_sec FROM attendance_system.lock_opened_log WHERE device_id = ? ORDER BY server_timestamp ASC, time_after_startup_sec ASC"

	// Execute the query with the given device ID
	var lockOpenedLogs []LockOpenedLog
	iter := l.session.Query(query, deviceID).Iter()
	for {
		var lockOpenedLog LockOpenedLog
		if !iter.Scan(&lockOpenedLog.DeviceID, &lockOpenedLog.CardUid, &lockOpenedLog.ServerTimestamp, &lockOpenedLog.TimeAfterStartupSec) {
			break
		}
		lockOpenedLogs = append(lockOpenedLogs, lockOpenedLog)
	}
	if err := iter.Close(); err != nil {
		return nil, err
	}

	return lockOpenedLogs, nil
}

type EmployeeLockOpenedCount struct {
	CardUid string
	Count   int
}

func (l *LockOpenedLogRepo) GetLockOpenedCountByDeviceId(deviceId string) ([]EmployeeLockOpenedCount, error) {
	// Construct the SELECT query
	query := "select card_uid, count(*) as count from attendance_system.lock_opened_log where device_id= ? group by device_id, card_uid;"

	// Execute the query with the given device ID
	var employeesLockOpenedCount []EmployeeLockOpenedCount
	iter := l.session.Query(query, deviceId).Iter()
	for {
		var employeeLockOpenedCount EmployeeLockOpenedCount
		if !iter.Scan(&employeeLockOpenedCount.CardUid, &employeeLockOpenedCount.Count) {
			break
		}
		employeesLockOpenedCount = append(employeesLockOpenedCount, employeeLockOpenedCount)
	}
	if err := iter.Close(); err != nil {
		return nil, err
	}

	return employeesLockOpenedCount, nil
}
