package api

import (
	"context"
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"server/config"
	"server/pkg/db"
	mqtt2 "server/pkg/mqtt"
	"server/proto/gen/pb-go/iot/attendance_system"
	"time"
)

type AttendanceSystem struct {
	attendance_system.UnimplementedAttendanceSystemServer
	adminCommandLogRepo db.AdminCommandLogRepo
	attendanceLogRepo   db.AttendanceLogRepo
	deviceRepo          db.DeviceRepo
	deviceStartupRepo   db.DeviceStartupRepo
	deviceStateLogRepo  db.DeviceStateLogRepo
	employeeRepo        db.EmployeeRepo
	lockOpenedLogRepo   db.LockOpenedLogRepo
	mqttPublisherClient mqtt.Client
	config              config.Config
}

func (a *AttendanceSystem) LedColor(request *attendance_system.LedColorRequest, server attendance_system.AttendanceSystem_LedColorServer) error {
	//TODO implement me
	panic("implement me")
}

func (a *AttendanceSystem) LockOpenedHistory(request *attendance_system.LockOpenedHistoryRequest, server attendance_system.AttendanceSystem_LockOpenedHistoryServer) error {
	//TODO implement me
	panic("implement me")
}

func (a *AttendanceSystem) ChangeLedColor(ctx context.Context, request *attendance_system.ChangeLedColorRequest) (*attendance_system.ChangeLedColorResponse, error) {
	payloadLedChangeColor := fmt.Sprintf("%d,LED_CHANGE_COLOR_%d%d%d", time.Now().Unix(), request.Red, request.Green, request.Blue)

	a.mqttPublisherClient.Publish(fmt.Sprintf("%s/%s", a.config.TopicNames.AdminCommand, request.DeviceId), mqtt2.ExactlyOnce, false, payloadLedChangeColor)
	return &attendance_system.ChangeLedColorResponse{}, nil
}

func (a *AttendanceSystem) OpenDoor(ctx context.Context, request *attendance_system.OpenDoorRequest) (*attendance_system.OpenDoorResponse, error) {
	//TODO implement me
	panic("implement me")
}

func (a *AttendanceSystem) GetAllDevices(ctx context.Context, request *attendance_system.GetDeviceIdsRequest) (*attendance_system.GetDeviceIdsResponse, error) {
	//TODO implement me
	panic("implement me")
}

func (a *AttendanceSystem) GetAllPresentPersons(ctx context.Context, request *attendance_system.GetPresentEmployeeRequest) (*attendance_system.GetPresentEmployeeResponse, error) {
	//TODO implement me
	panic("implement me")
}
