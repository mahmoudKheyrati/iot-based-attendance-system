// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package com.example.iot_app.proto;

public interface EmployeePresenceStatusResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ir.mahmoud.iot_attendance_system.EmployeePresenceStatusResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string first_name = 1;</code>
   * @return The firstName.
   */
  String getFirstName();
  /**
   * <code>string first_name = 1;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string last_name = 2;</code>
   * @return The lastName.
   */
  String getLastName();
  /**
   * <code>string last_name = 2;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>bool is_present = 3;</code>
   * @return The isPresent.
   */
  boolean getIsPresent();
}