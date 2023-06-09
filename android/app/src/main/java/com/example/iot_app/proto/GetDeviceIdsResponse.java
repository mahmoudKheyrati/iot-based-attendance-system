// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package com.example.iot_app.proto;

/**
 * Protobuf type {@code ir.mahmoud.iot_attendance_system.GetDeviceIdsResponse}
 */
public final class GetDeviceIdsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ir.mahmoud.iot_attendance_system.GetDeviceIdsResponse)
    GetDeviceIdsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetDeviceIdsResponse.newBuilder() to construct.
  private GetDeviceIdsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetDeviceIdsResponse() {
    devices_ = java.util.Collections.emptyList();
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetDeviceIdsResponse();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetDeviceIdsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              devices_ = new java.util.ArrayList<Device>();
              mutable_bitField0_ |= 0x00000001;
            }
            devices_.add(
                input.readMessage(Device.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        devices_ = java.util.Collections.unmodifiableList(devices_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetDeviceIdsResponse.class, Builder.class);
  }

  public static final int DEVICES_FIELD_NUMBER = 1;
  private java.util.List<Device> devices_;
  /**
   * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
   */
  @Override
  public java.util.List<Device> getDevicesList() {
    return devices_;
  }
  /**
   * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
   */
  @Override
  public java.util.List<? extends DeviceOrBuilder>
      getDevicesOrBuilderList() {
    return devices_;
  }
  /**
   * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
   */
  @Override
  public int getDevicesCount() {
    return devices_.size();
  }
  /**
   * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
   */
  @Override
  public Device getDevices(int index) {
    return devices_.get(index);
  }
  /**
   * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
   */
  @Override
  public DeviceOrBuilder getDevicesOrBuilder(
      int index) {
    return devices_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < devices_.size(); i++) {
      output.writeMessage(1, devices_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < devices_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, devices_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GetDeviceIdsResponse)) {
      return super.equals(obj);
    }
    GetDeviceIdsResponse other = (GetDeviceIdsResponse) obj;

    if (!getDevicesList()
        .equals(other.getDevicesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDevicesCount() > 0) {
      hash = (37 * hash) + DEVICES_FIELD_NUMBER;
      hash = (53 * hash) + getDevicesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetDeviceIdsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetDeviceIdsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetDeviceIdsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetDeviceIdsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetDeviceIdsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetDeviceIdsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetDeviceIdsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetDeviceIdsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetDeviceIdsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GetDeviceIdsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetDeviceIdsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetDeviceIdsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GetDeviceIdsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ir.mahmoud.iot_attendance_system.GetDeviceIdsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ir.mahmoud.iot_attendance_system.GetDeviceIdsResponse)
      GetDeviceIdsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetDeviceIdsResponse.class, Builder.class);
    }

    // Construct using com.example.iot_app.proto.GetDeviceIdsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getDevicesFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      if (devicesBuilder_ == null) {
        devices_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        devicesBuilder_.clear();
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_GetDeviceIdsResponse_descriptor;
    }

    @Override
    public GetDeviceIdsResponse getDefaultInstanceForType() {
      return GetDeviceIdsResponse.getDefaultInstance();
    }

    @Override
    public GetDeviceIdsResponse build() {
      GetDeviceIdsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetDeviceIdsResponse buildPartial() {
      GetDeviceIdsResponse result = new GetDeviceIdsResponse(this);
      int from_bitField0_ = bitField0_;
      if (devicesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          devices_ = java.util.Collections.unmodifiableList(devices_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.devices_ = devices_;
      } else {
        result.devices_ = devicesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GetDeviceIdsResponse) {
        return mergeFrom((GetDeviceIdsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetDeviceIdsResponse other) {
      if (other == GetDeviceIdsResponse.getDefaultInstance()) return this;
      if (devicesBuilder_ == null) {
        if (!other.devices_.isEmpty()) {
          if (devices_.isEmpty()) {
            devices_ = other.devices_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDevicesIsMutable();
            devices_.addAll(other.devices_);
          }
          onChanged();
        }
      } else {
        if (!other.devices_.isEmpty()) {
          if (devicesBuilder_.isEmpty()) {
            devicesBuilder_.dispose();
            devicesBuilder_ = null;
            devices_ = other.devices_;
            bitField0_ = (bitField0_ & ~0x00000001);
            devicesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDevicesFieldBuilder() : null;
          } else {
            devicesBuilder_.addAllMessages(other.devices_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      GetDeviceIdsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GetDeviceIdsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<Device> devices_ =
      java.util.Collections.emptyList();
    private void ensureDevicesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        devices_ = new java.util.ArrayList<Device>(devices_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        Device, Device.Builder, DeviceOrBuilder> devicesBuilder_;

    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public java.util.List<Device> getDevicesList() {
      if (devicesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(devices_);
      } else {
        return devicesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public int getDevicesCount() {
      if (devicesBuilder_ == null) {
        return devices_.size();
      } else {
        return devicesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Device getDevices(int index) {
      if (devicesBuilder_ == null) {
        return devices_.get(index);
      } else {
        return devicesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder setDevices(
        int index, Device value) {
      if (devicesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDevicesIsMutable();
        devices_.set(index, value);
        onChanged();
      } else {
        devicesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder setDevices(
        int index, Device.Builder builderForValue) {
      if (devicesBuilder_ == null) {
        ensureDevicesIsMutable();
        devices_.set(index, builderForValue.build());
        onChanged();
      } else {
        devicesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder addDevices(Device value) {
      if (devicesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDevicesIsMutable();
        devices_.add(value);
        onChanged();
      } else {
        devicesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder addDevices(
        int index, Device value) {
      if (devicesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDevicesIsMutable();
        devices_.add(index, value);
        onChanged();
      } else {
        devicesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder addDevices(
        Device.Builder builderForValue) {
      if (devicesBuilder_ == null) {
        ensureDevicesIsMutable();
        devices_.add(builderForValue.build());
        onChanged();
      } else {
        devicesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder addDevices(
        int index, Device.Builder builderForValue) {
      if (devicesBuilder_ == null) {
        ensureDevicesIsMutable();
        devices_.add(index, builderForValue.build());
        onChanged();
      } else {
        devicesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder addAllDevices(
        Iterable<? extends Device> values) {
      if (devicesBuilder_ == null) {
        ensureDevicesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, devices_);
        onChanged();
      } else {
        devicesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder clearDevices() {
      if (devicesBuilder_ == null) {
        devices_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        devicesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Builder removeDevices(int index) {
      if (devicesBuilder_ == null) {
        ensureDevicesIsMutable();
        devices_.remove(index);
        onChanged();
      } else {
        devicesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Device.Builder getDevicesBuilder(
        int index) {
      return getDevicesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public DeviceOrBuilder getDevicesOrBuilder(
        int index) {
      if (devicesBuilder_ == null) {
        return devices_.get(index);  } else {
        return devicesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public java.util.List<? extends DeviceOrBuilder>
         getDevicesOrBuilderList() {
      if (devicesBuilder_ != null) {
        return devicesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(devices_);
      }
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Device.Builder addDevicesBuilder() {
      return getDevicesFieldBuilder().addBuilder(
          Device.getDefaultInstance());
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public Device.Builder addDevicesBuilder(
        int index) {
      return getDevicesFieldBuilder().addBuilder(
          index, Device.getDefaultInstance());
    }
    /**
     * <code>repeated .ir.mahmoud.iot_attendance_system.Device devices = 1;</code>
     */
    public java.util.List<Device.Builder>
         getDevicesBuilderList() {
      return getDevicesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        Device, Device.Builder, DeviceOrBuilder>
        getDevicesFieldBuilder() {
      if (devicesBuilder_ == null) {
        devicesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            Device, Device.Builder, DeviceOrBuilder>(
                devices_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        devices_ = null;
      }
      return devicesBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ir.mahmoud.iot_attendance_system.GetDeviceIdsResponse)
  }

  // @@protoc_insertion_point(class_scope:ir.mahmoud.iot_attendance_system.GetDeviceIdsResponse)
  private static final GetDeviceIdsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetDeviceIdsResponse();
  }

  public static GetDeviceIdsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetDeviceIdsResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetDeviceIdsResponse>() {
    @Override
    public GetDeviceIdsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetDeviceIdsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetDeviceIdsResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetDeviceIdsResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public GetDeviceIdsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

