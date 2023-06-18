package db

import (
	"github.com/gocql/gocql"
	"time"
)

type DeviceStateLog struct {
	DeviceID            string
	ServerTimestamp     time.Time
	TimeAfterStartupSec int
	LedRed              bool
	LedGreen            bool
	LedBlue             bool
}

type DeviceStateLogRepo struct {
	session *gocql.Session
}

func NewDeviceStateLogRepo(session *gocql.Session) *DeviceStateLogRepo {
	return &DeviceStateLogRepo{session: session}
}

func (d *DeviceStateLogRepo) Insert(deviceStateLog DeviceStateLog) error {
	query := "INSERT INTO attendance_system.device_state_log (device_id, server_timestamp, time_after_startup_sec, led_red, led_green, led_blue) VALUES (?, ?, ?, ?, ?, ?)"

	// Execute the query with the given device state log data
	err := d.session.Query(query, deviceStateLog.DeviceID, deviceStateLog.ServerTimestamp, deviceStateLog.TimeAfterStartupSec, deviceStateLog.LedRed, deviceStateLog.LedGreen, deviceStateLog.LedBlue).Exec()
	return err
}
