package db

import (
	"github.com/gocql/gocql"
	"time"
)

type AttendanceLog struct {
	Timestamp       time.Time
	DeviceID        string
	CardUID         gocql.UUID
	Action          string
	ResponsePayload string
}

type AttendanceLogRepo struct {
	session *gocql.Session
}

func NewAttendanceLogRepo(session *gocql.Session) *AttendanceLogRepo {
	return &AttendanceLogRepo{session: session}
}

func (a *AttendanceLogRepo) Insert(attendanceLog AttendanceLog) error {

	query := "INSERT INTO attendance_system.attendance_log (timestamp, device_id, card_uid, action, response_payload) VALUES (?, ?, ?, ?, ?)"

	err := a.session.Query(query, attendanceLog.Timestamp, attendanceLog.DeviceID, attendanceLog.CardUID, attendanceLog.Action, attendanceLog.ResponsePayload).Exec()

	return err
}
