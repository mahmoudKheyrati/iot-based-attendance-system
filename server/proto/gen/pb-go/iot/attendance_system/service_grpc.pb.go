// Code generated by protoc-gen-go-grpc. DO NOT EDIT.
// versions:
// - protoc-gen-go-grpc v1.2.0
// - protoc             v3.21.6
// source: service.proto

package attendance_system

import (
	context "context"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
)

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
// Requires gRPC-Go v1.32.0 or later.
const _ = grpc.SupportPackageIsVersion7

// AttendanceSystemClient is the client API for AttendanceSystem service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://pkg.go.dev/google.golang.org/grpc/?tab=doc#ClientConn.NewStream.
type AttendanceSystemClient interface {
	LedColor(ctx context.Context, in *LedColorRequest, opts ...grpc.CallOption) (AttendanceSystem_LedColorClient, error)
	LockOpenedHistory(ctx context.Context, in *LockOpenedHistoryRequest, opts ...grpc.CallOption) (AttendanceSystem_LockOpenedHistoryClient, error)
	ChangeLedColor(ctx context.Context, in *ChangeLedColorRequest, opts ...grpc.CallOption) (*ChangeLedColorResponse, error)
	OpenDoor(ctx context.Context, in *OpenDoorRequest, opts ...grpc.CallOption) (*OpenDoorResponse, error)
	GetAllDeviceIds(ctx context.Context, in *GetDeviceIdsRequest, opts ...grpc.CallOption) (*GetDeviceIdsResponse, error)
	EmployeesPresenceStatus(ctx context.Context, in *EmployeePresenceStatusRequest, opts ...grpc.CallOption) (AttendanceSystem_EmployeesPresenceStatusClient, error)
}

type attendanceSystemClient struct {
	cc grpc.ClientConnInterface
}

func NewAttendanceSystemClient(cc grpc.ClientConnInterface) AttendanceSystemClient {
	return &attendanceSystemClient{cc}
}

func (c *attendanceSystemClient) LedColor(ctx context.Context, in *LedColorRequest, opts ...grpc.CallOption) (AttendanceSystem_LedColorClient, error) {
	stream, err := c.cc.NewStream(ctx, &AttendanceSystem_ServiceDesc.Streams[0], "/ir.mahmoud.iot_attendance_system.attendanceSystem/ledColor", opts...)
	if err != nil {
		return nil, err
	}
	x := &attendanceSystemLedColorClient{stream}
	if err := x.ClientStream.SendMsg(in); err != nil {
		return nil, err
	}
	if err := x.ClientStream.CloseSend(); err != nil {
		return nil, err
	}
	return x, nil
}

type AttendanceSystem_LedColorClient interface {
	Recv() (*LedColorResponse, error)
	grpc.ClientStream
}

type attendanceSystemLedColorClient struct {
	grpc.ClientStream
}

func (x *attendanceSystemLedColorClient) Recv() (*LedColorResponse, error) {
	m := new(LedColorResponse)
	if err := x.ClientStream.RecvMsg(m); err != nil {
		return nil, err
	}
	return m, nil
}

func (c *attendanceSystemClient) LockOpenedHistory(ctx context.Context, in *LockOpenedHistoryRequest, opts ...grpc.CallOption) (AttendanceSystem_LockOpenedHistoryClient, error) {
	stream, err := c.cc.NewStream(ctx, &AttendanceSystem_ServiceDesc.Streams[1], "/ir.mahmoud.iot_attendance_system.attendanceSystem/lockOpenedHistory", opts...)
	if err != nil {
		return nil, err
	}
	x := &attendanceSystemLockOpenedHistoryClient{stream}
	if err := x.ClientStream.SendMsg(in); err != nil {
		return nil, err
	}
	if err := x.ClientStream.CloseSend(); err != nil {
		return nil, err
	}
	return x, nil
}

type AttendanceSystem_LockOpenedHistoryClient interface {
	Recv() (*LockOpenedHistoryResponse, error)
	grpc.ClientStream
}

type attendanceSystemLockOpenedHistoryClient struct {
	grpc.ClientStream
}

func (x *attendanceSystemLockOpenedHistoryClient) Recv() (*LockOpenedHistoryResponse, error) {
	m := new(LockOpenedHistoryResponse)
	if err := x.ClientStream.RecvMsg(m); err != nil {
		return nil, err
	}
	return m, nil
}

func (c *attendanceSystemClient) ChangeLedColor(ctx context.Context, in *ChangeLedColorRequest, opts ...grpc.CallOption) (*ChangeLedColorResponse, error) {
	out := new(ChangeLedColorResponse)
	err := c.cc.Invoke(ctx, "/ir.mahmoud.iot_attendance_system.attendanceSystem/changeLedColor", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *attendanceSystemClient) OpenDoor(ctx context.Context, in *OpenDoorRequest, opts ...grpc.CallOption) (*OpenDoorResponse, error) {
	out := new(OpenDoorResponse)
	err := c.cc.Invoke(ctx, "/ir.mahmoud.iot_attendance_system.attendanceSystem/openDoor", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *attendanceSystemClient) GetAllDeviceIds(ctx context.Context, in *GetDeviceIdsRequest, opts ...grpc.CallOption) (*GetDeviceIdsResponse, error) {
	out := new(GetDeviceIdsResponse)
	err := c.cc.Invoke(ctx, "/ir.mahmoud.iot_attendance_system.attendanceSystem/getAllDeviceIds", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *attendanceSystemClient) EmployeesPresenceStatus(ctx context.Context, in *EmployeePresenceStatusRequest, opts ...grpc.CallOption) (AttendanceSystem_EmployeesPresenceStatusClient, error) {
	stream, err := c.cc.NewStream(ctx, &AttendanceSystem_ServiceDesc.Streams[2], "/ir.mahmoud.iot_attendance_system.attendanceSystem/employeesPresenceStatus", opts...)
	if err != nil {
		return nil, err
	}
	x := &attendanceSystemEmployeesPresenceStatusClient{stream}
	if err := x.ClientStream.SendMsg(in); err != nil {
		return nil, err
	}
	if err := x.ClientStream.CloseSend(); err != nil {
		return nil, err
	}
	return x, nil
}

type AttendanceSystem_EmployeesPresenceStatusClient interface {
	Recv() (*EmployeePresenceStatusResponse, error)
	grpc.ClientStream
}

type attendanceSystemEmployeesPresenceStatusClient struct {
	grpc.ClientStream
}

func (x *attendanceSystemEmployeesPresenceStatusClient) Recv() (*EmployeePresenceStatusResponse, error) {
	m := new(EmployeePresenceStatusResponse)
	if err := x.ClientStream.RecvMsg(m); err != nil {
		return nil, err
	}
	return m, nil
}

// AttendanceSystemServer is the server API for AttendanceSystem service.
// All implementations should embed UnimplementedAttendanceSystemServer
// for forward compatibility
type AttendanceSystemServer interface {
	LedColor(*LedColorRequest, AttendanceSystem_LedColorServer) error
	LockOpenedHistory(*LockOpenedHistoryRequest, AttendanceSystem_LockOpenedHistoryServer) error
	ChangeLedColor(context.Context, *ChangeLedColorRequest) (*ChangeLedColorResponse, error)
	OpenDoor(context.Context, *OpenDoorRequest) (*OpenDoorResponse, error)
	GetAllDeviceIds(context.Context, *GetDeviceIdsRequest) (*GetDeviceIdsResponse, error)
	EmployeesPresenceStatus(*EmployeePresenceStatusRequest, AttendanceSystem_EmployeesPresenceStatusServer) error
}

// UnimplementedAttendanceSystemServer should be embedded to have forward compatible implementations.
type UnimplementedAttendanceSystemServer struct {
}

func (UnimplementedAttendanceSystemServer) LedColor(*LedColorRequest, AttendanceSystem_LedColorServer) error {
	return status.Errorf(codes.Unimplemented, "method LedColor not implemented")
}
func (UnimplementedAttendanceSystemServer) LockOpenedHistory(*LockOpenedHistoryRequest, AttendanceSystem_LockOpenedHistoryServer) error {
	return status.Errorf(codes.Unimplemented, "method LockOpenedHistory not implemented")
}
func (UnimplementedAttendanceSystemServer) ChangeLedColor(context.Context, *ChangeLedColorRequest) (*ChangeLedColorResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method ChangeLedColor not implemented")
}
func (UnimplementedAttendanceSystemServer) OpenDoor(context.Context, *OpenDoorRequest) (*OpenDoorResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method OpenDoor not implemented")
}
func (UnimplementedAttendanceSystemServer) GetAllDeviceIds(context.Context, *GetDeviceIdsRequest) (*GetDeviceIdsResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetAllDeviceIds not implemented")
}
func (UnimplementedAttendanceSystemServer) EmployeesPresenceStatus(*EmployeePresenceStatusRequest, AttendanceSystem_EmployeesPresenceStatusServer) error {
	return status.Errorf(codes.Unimplemented, "method EmployeesPresenceStatus not implemented")
}

// UnsafeAttendanceSystemServer may be embedded to opt out of forward compatibility for this service.
// Use of this interface is not recommended, as added methods to AttendanceSystemServer will
// result in compilation errors.
type UnsafeAttendanceSystemServer interface {
	mustEmbedUnimplementedAttendanceSystemServer()
}

func RegisterAttendanceSystemServer(s grpc.ServiceRegistrar, srv AttendanceSystemServer) {
	s.RegisterService(&AttendanceSystem_ServiceDesc, srv)
}

func _AttendanceSystem_LedColor_Handler(srv interface{}, stream grpc.ServerStream) error {
	m := new(LedColorRequest)
	if err := stream.RecvMsg(m); err != nil {
		return err
	}
	return srv.(AttendanceSystemServer).LedColor(m, &attendanceSystemLedColorServer{stream})
}

type AttendanceSystem_LedColorServer interface {
	Send(*LedColorResponse) error
	grpc.ServerStream
}

type attendanceSystemLedColorServer struct {
	grpc.ServerStream
}

func (x *attendanceSystemLedColorServer) Send(m *LedColorResponse) error {
	return x.ServerStream.SendMsg(m)
}

func _AttendanceSystem_LockOpenedHistory_Handler(srv interface{}, stream grpc.ServerStream) error {
	m := new(LockOpenedHistoryRequest)
	if err := stream.RecvMsg(m); err != nil {
		return err
	}
	return srv.(AttendanceSystemServer).LockOpenedHistory(m, &attendanceSystemLockOpenedHistoryServer{stream})
}

type AttendanceSystem_LockOpenedHistoryServer interface {
	Send(*LockOpenedHistoryResponse) error
	grpc.ServerStream
}

type attendanceSystemLockOpenedHistoryServer struct {
	grpc.ServerStream
}

func (x *attendanceSystemLockOpenedHistoryServer) Send(m *LockOpenedHistoryResponse) error {
	return x.ServerStream.SendMsg(m)
}

func _AttendanceSystem_ChangeLedColor_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(ChangeLedColorRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AttendanceSystemServer).ChangeLedColor(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ir.mahmoud.iot_attendance_system.attendanceSystem/changeLedColor",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AttendanceSystemServer).ChangeLedColor(ctx, req.(*ChangeLedColorRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _AttendanceSystem_OpenDoor_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(OpenDoorRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AttendanceSystemServer).OpenDoor(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ir.mahmoud.iot_attendance_system.attendanceSystem/openDoor",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AttendanceSystemServer).OpenDoor(ctx, req.(*OpenDoorRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _AttendanceSystem_GetAllDeviceIds_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetDeviceIdsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AttendanceSystemServer).GetAllDeviceIds(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ir.mahmoud.iot_attendance_system.attendanceSystem/getAllDeviceIds",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AttendanceSystemServer).GetAllDeviceIds(ctx, req.(*GetDeviceIdsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _AttendanceSystem_EmployeesPresenceStatus_Handler(srv interface{}, stream grpc.ServerStream) error {
	m := new(EmployeePresenceStatusRequest)
	if err := stream.RecvMsg(m); err != nil {
		return err
	}
	return srv.(AttendanceSystemServer).EmployeesPresenceStatus(m, &attendanceSystemEmployeesPresenceStatusServer{stream})
}

type AttendanceSystem_EmployeesPresenceStatusServer interface {
	Send(*EmployeePresenceStatusResponse) error
	grpc.ServerStream
}

type attendanceSystemEmployeesPresenceStatusServer struct {
	grpc.ServerStream
}

func (x *attendanceSystemEmployeesPresenceStatusServer) Send(m *EmployeePresenceStatusResponse) error {
	return x.ServerStream.SendMsg(m)
}

// AttendanceSystem_ServiceDesc is the grpc.ServiceDesc for AttendanceSystem service.
// It's only intended for direct use with grpc.RegisterService,
// and not to be introspected or modified (even as a copy)
var AttendanceSystem_ServiceDesc = grpc.ServiceDesc{
	ServiceName: "ir.mahmoud.iot_attendance_system.attendanceSystem",
	HandlerType: (*AttendanceSystemServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "changeLedColor",
			Handler:    _AttendanceSystem_ChangeLedColor_Handler,
		},
		{
			MethodName: "openDoor",
			Handler:    _AttendanceSystem_OpenDoor_Handler,
		},
		{
			MethodName: "getAllDeviceIds",
			Handler:    _AttendanceSystem_GetAllDeviceIds_Handler,
		},
	},
	Streams: []grpc.StreamDesc{
		{
			StreamName:    "ledColor",
			Handler:       _AttendanceSystem_LedColor_Handler,
			ServerStreams: true,
		},
		{
			StreamName:    "lockOpenedHistory",
			Handler:       _AttendanceSystem_LockOpenedHistory_Handler,
			ServerStreams: true,
		},
		{
			StreamName:    "employeesPresenceStatus",
			Handler:       _AttendanceSystem_EmployeesPresenceStatus_Handler,
			ServerStreams: true,
		},
	},
	Metadata: "service.proto",
}
