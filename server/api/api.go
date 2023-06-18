package api

import (
	"context"
	"server/proto/gen/pb-go/iot/attendance_system"
)

type AttendanceSystem struct {
	attendance_system.UnimplementedAttendanceSystemServer
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
	//TODO implement me
	panic("implement me")
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
