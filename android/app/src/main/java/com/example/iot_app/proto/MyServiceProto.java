// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package com.example.iot_app.proto;

public final class MyServiceProto {
  private MyServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_LedColorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_LedColorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_LedColorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_LedColorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_history_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_history_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_OpenDoorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_OpenDoorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_OpenDoorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_OpenDoorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_Device_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_Device_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rservice.proto\022 ir.mahmoud.iot_attendan" +
      "ce_system\"$\n\017LedColorRequest\022\021\n\tdevice_i" +
      "d\030\001 \001(\t\"<\n\020LedColorResponse\022\013\n\003red\030\001 \001(\005" +
      "\022\r\n\005green\030\002 \001(\005\022\014\n\004blue\030\003 \001(\005\"-\n\030LockOpe" +
      "nedHistoryRequest\022\021\n\tdevice_id\030\001 \001(\t\"\270\001\n" +
      "\031LockOpenedHistoryResponse\022V\n\thistories\030" +
      "\001 \003(\0132C.ir.mahmoud.iot_attendance_system" +
      ".LockOpenedHistoryResponse.history\032C\n\007hi" +
      "story\022\030\n\020server_timestamp\030\001 \001(\003\022\036\n\026time_" +
      "after_startup_sec\030\002 \001(\005\"T\n\025ChangeLedColo" +
      "rRequest\022\021\n\tdevice_id\030\001 \001(\t\022\013\n\003red\030\002 \001(\005" +
      "\022\r\n\005green\030\003 \001(\005\022\014\n\004blue\030\004 \001(\005\"\030\n\026ChangeL" +
      "edColorResponse\"$\n\017OpenDoorRequest\022\021\n\tde" +
      "vice_id\030\001 \001(\t\"\022\n\020OpenDoorResponse\"(\n\023Get" +
      "DeviceIdsRequest\022\021\n\tdevice_id\030\001 \001(\t\"\033\n\006D" +
      "evice\022\021\n\tdevice_id\030\001 \001(\t\"Q\n\024GetDeviceIds" +
      "Response\0229\n\007devices\030\001 \003(\0132(.ir.mahmoud.i" +
      "ot_attendance_system.Device\"2\n\035EmployeeP" +
      "resenceStatusRequest\022\021\n\tdevice_id\030\001 \001(\t\"" +
      "[\n\036EmployeePresenceStatusResponse\022\022\n\nfir" +
      "st_name\030\001 \001(\t\022\021\n\tlast_name\030\002 \001(\t\022\022\n\nis_p" +
      "resent\030\003 \001(\0102\265\006\n\020attendanceSystem\022s\n\010led" +
      "Color\0221.ir.mahmoud.iot_attendance_system" +
      ".LedColorRequest\0322.ir.mahmoud.iot_attend" +
      "ance_system.LedColorResponse0\001\022\216\001\n\021lockO" +
      "penedHistory\022:.ir.mahmoud.iot_attendance" +
      "_system.LockOpenedHistoryRequest\032;.ir.ma" +
      "hmoud.iot_attendance_system.LockOpenedHi" +
      "storyResponse0\001\022\203\001\n\016changeLedColor\0227.ir." +
      "mahmoud.iot_attendance_system.ChangeLedC" +
      "olorRequest\0328.ir.mahmoud.iot_attendance_" +
      "system.ChangeLedColorResponse\022q\n\010openDoo" +
      "r\0221.ir.mahmoud.iot_attendance_system.Ope" +
      "nDoorRequest\0322.ir.mahmoud.iot_attendance" +
      "_system.OpenDoorResponse\022\200\001\n\017getAllDevic" +
      "eIds\0225.ir.mahmoud.iot_attendance_system." +
      "GetDeviceIdsRequest\0326.ir.mahmoud.iot_att" +
      "endance_system.GetDeviceIdsResponse\022\236\001\n\027" +
      "employeesPresenceStatus\022?.ir.mahmoud.iot" +
      "_attendance_system.EmployeePresenceStatu" +
      "sRequest\032@.ir.mahmoud.iot_attendance_sys" +
      "tem.EmployeePresenceStatusResponse0\001B-\n\031" +
      "com.example.iot_app.protoB\016MyServiceProt" +
      "oP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ir_mahmoud_iot_attendance_system_LedColorRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ir_mahmoud_iot_attendance_system_LedColorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_LedColorRequest_descriptor,
        new String[] { "DeviceId", });
    internal_static_ir_mahmoud_iot_attendance_system_LedColorResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ir_mahmoud_iot_attendance_system_LedColorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_LedColorResponse_descriptor,
        new String[] { "Red", "Green", "Blue", });
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryRequest_descriptor,
        new String[] { "DeviceId", });
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_descriptor,
        new String[] { "Histories", });
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_history_descriptor =
      internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_descriptor.getNestedTypes().get(0);
    internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_history_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_LockOpenedHistoryResponse_history_descriptor,
        new String[] { "ServerTimestamp", "TimeAfterStartupSec", });
    internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_descriptor,
        new String[] { "DeviceId", "Red", "Green", "Blue", });
    internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorResponse_descriptor,
        new String[] { });
    internal_static_ir_mahmoud_iot_attendance_system_OpenDoorRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ir_mahmoud_iot_attendance_system_OpenDoorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_OpenDoorRequest_descriptor,
        new String[] { "DeviceId", });
    internal_static_ir_mahmoud_iot_attendance_system_OpenDoorResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ir_mahmoud_iot_attendance_system_OpenDoorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_OpenDoorResponse_descriptor,
        new String[] { });
    internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsRequest_descriptor,
        new String[] { "DeviceId", });
    internal_static_ir_mahmoud_iot_attendance_system_Device_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_ir_mahmoud_iot_attendance_system_Device_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_Device_descriptor,
        new String[] { "DeviceId", });
    internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_descriptor,
        new String[] { "Devices", });
    internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusRequest_descriptor,
        new String[] { "DeviceId", });
    internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ir_mahmoud_iot_attendance_system_EmployeePresenceStatusResponse_descriptor,
        new String[] { "FirstName", "LastName", "IsPresent", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
