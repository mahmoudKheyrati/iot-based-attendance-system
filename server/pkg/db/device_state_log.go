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

func (d *DeviceStateLogRepo) GetLatestStateByDeviceID(deviceID string) (*DeviceStateLog, error) {
	// Construct the SELECT query
	query := "SELECT device_id, server_timestamp, time_after_startup_sec, led_red, led_green, led_blue FROM attendance_system.device_state_log WHERE device_id = ? ORDER BY server_timestamp DESC, time_after_startup_sec DESC LIMIT 1"

	// Execute the query with the given device ID
	var deviceStateLog DeviceStateLog
	if err := d.session.Query(query, deviceID).Scan(&deviceStateLog.DeviceID, &deviceStateLog.ServerTimestamp, &deviceStateLog.TimeAfterStartupSec, &deviceStateLog.LedRed, &deviceStateLog.LedGreen, &deviceStateLog.LedBlue); err != nil {
		return nil, err
	}

	return &deviceStateLog, nil
}
