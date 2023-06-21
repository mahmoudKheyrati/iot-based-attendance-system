package db

import (
	"github.com/gocql/gocql"
	"time"
)

type DeviceStartup struct {
	DeviceID          string
	ServerTimestamp   time.Time
	TimeAfterStartSec int
}

type DeviceStartupRepo struct {
	session *gocql.Session
}

func NewDeviceStartupRepo(session *gocql.Session) *DeviceStartupRepo {
	return &DeviceStartupRepo{session: session}
}

type DeviceLastStartup struct {
	DeviceID    gocql.UUID
	LastStartup time.Time
}

func (d *DeviceStartupRepo) Insert(deviceStartup DeviceStartup) error {

	query := "INSERT INTO attendance_system.device_startup (device_id, server_timestamp, time_after_start_sec) VALUES (?, ?, ?)"

	err := d.session.Query(query, deviceStartup.DeviceID, deviceStartup.ServerTimestamp, deviceStartup.TimeAfterStartSec).Exec()
	return err
}

func (d *DeviceStartupRepo) GetDeviceLastStartupById(deviceId string) (time.Time, int, error) {

	query := "SELECT server_timestamp, time_after_start_sec FROM attendance_system.device_startup WHERE device_id = ? ORDER BY server_timestamp DESC LIMIT 1"

	iter := d.session.Query(query, deviceId).Iter()

	var lastStartup time.Time
	var timeAfterStartSec int

	if iter.Scan(&lastStartup, &timeAfterStartSec) {
		lastStartup = lastStartup.Add(time.Duration(timeAfterStartSec) * time.Second)
	}

	err := iter.Close()
	return lastStartup, timeAfterStartSec, err
}
