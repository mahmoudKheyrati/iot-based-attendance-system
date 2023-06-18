package db

import (
	"github.com/gocql/gocql"
)

type Point struct {
	Lat  float64
	Long float64
}
type Device struct {
	ID       gocql.UUID `db:"id"`
	Name     string     `db:"name"`
	Location Point      `db:"location"`
	Rules    []string   `db:"rules"`
}
type DeviceRepo struct {
	session *gocql.Session
}

func NewDeviceRepo(session *gocql.Session) *DeviceRepo {
	return &DeviceRepo{session: session}
}

func (d *DeviceRepo) InsertDevice(device Device) error {
	insertQuery := "INSERT INTO device (id, name, location, rules) VALUES (?, ?, ?, ?)"
	insertArgs := []interface{}{device.ID, device.Name, device.Location, device.Rules}
	err := d.session.Query(insertQuery, insertArgs).Exec()
	return err
}

func (d *DeviceRepo) GetAllDevices() ([]Device, error) {

	var devices []Device

	query := "SELECT id, name, location, rules FROM attendance_system.device"

	iter := d.session.Query(query).Iter()

	var id gocql.UUID
	var name string
	var location Point
	var rules []string
	for iter.Scan(&id, &name, &location, &rules) {
		devices = append(devices, Device{ID: id, Name: name, Location: location, Rules: rules})
	}

	err := iter.Close()
	return devices, err
}

func (d *DeviceRepo) GetDeviceByName(deviceName string) (Device, error) {

	var device Device

	query := "SELECT id, name, location, rules FROM attendance_system.device_by_name WHERE name = ? limit 1"

	iter := d.session.Query(query, deviceName).Iter()
	defer iter.Close()

	var id gocql.UUID
	var name string
	var location Point
	var rules []string
	for iter.Scan(&id, &name, &location, &rules) {
		device = Device{ID: id, Name: name, Location: location, Rules: rules}
	}

	err := iter.Close()
	return device, err
}
