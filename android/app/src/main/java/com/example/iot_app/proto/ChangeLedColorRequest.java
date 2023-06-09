// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package com.example.iot_app.proto;

/**
 * Protobuf type {@code ir.mahmoud.iot_attendance_system.ChangeLedColorRequest}
 */
public final class ChangeLedColorRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ir.mahmoud.iot_attendance_system.ChangeLedColorRequest)
    ChangeLedColorRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChangeLedColorRequest.newBuilder() to construct.
  private ChangeLedColorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChangeLedColorRequest() {
    deviceId_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new ChangeLedColorRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChangeLedColorRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
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
            String s = input.readStringRequireUtf8();

            deviceId_ = s;
            break;
          }
          case 16: {

            red_ = input.readInt32();
            break;
          }
          case 24: {

            green_ = input.readInt32();
            break;
          }
          case 32: {

            blue_ = input.readInt32();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ChangeLedColorRequest.class, Builder.class);
  }

  public static final int DEVICE_ID_FIELD_NUMBER = 1;
  private volatile Object deviceId_;
  /**
   * <code>string device_id = 1;</code>
   * @return The deviceId.
   */
  @Override
  public String getDeviceId() {
    Object ref = deviceId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      deviceId_ = s;
      return s;
    }
  }
  /**
   * <code>string device_id = 1;</code>
   * @return The bytes for deviceId.
   */
  @Override
  public com.google.protobuf.ByteString
      getDeviceIdBytes() {
    Object ref = deviceId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      deviceId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RED_FIELD_NUMBER = 2;
  private int red_;
  /**
   * <code>int32 red = 2;</code>
   * @return The red.
   */
  @Override
  public int getRed() {
    return red_;
  }

  public static final int GREEN_FIELD_NUMBER = 3;
  private int green_;
  /**
   * <code>int32 green = 3;</code>
   * @return The green.
   */
  @Override
  public int getGreen() {
    return green_;
  }

  public static final int BLUE_FIELD_NUMBER = 4;
  private int blue_;
  /**
   * <code>int32 blue = 4;</code>
   * @return The blue.
   */
  @Override
  public int getBlue() {
    return blue_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(deviceId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceId_);
    }
    if (red_ != 0) {
      output.writeInt32(2, red_);
    }
    if (green_ != 0) {
      output.writeInt32(3, green_);
    }
    if (blue_ != 0) {
      output.writeInt32(4, blue_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(deviceId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceId_);
    }
    if (red_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, red_);
    }
    if (green_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, green_);
    }
    if (blue_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, blue_);
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
    if (!(obj instanceof ChangeLedColorRequest)) {
      return super.equals(obj);
    }
    ChangeLedColorRequest other = (ChangeLedColorRequest) obj;

    if (!getDeviceId()
        .equals(other.getDeviceId())) return false;
    if (getRed()
        != other.getRed()) return false;
    if (getGreen()
        != other.getGreen()) return false;
    if (getBlue()
        != other.getBlue()) return false;
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
    hash = (37 * hash) + DEVICE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getDeviceId().hashCode();
    hash = (37 * hash) + RED_FIELD_NUMBER;
    hash = (53 * hash) + getRed();
    hash = (37 * hash) + GREEN_FIELD_NUMBER;
    hash = (53 * hash) + getGreen();
    hash = (37 * hash) + BLUE_FIELD_NUMBER;
    hash = (53 * hash) + getBlue();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ChangeLedColorRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ChangeLedColorRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ChangeLedColorRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ChangeLedColorRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ChangeLedColorRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ChangeLedColorRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ChangeLedColorRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ChangeLedColorRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ChangeLedColorRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ChangeLedColorRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ChangeLedColorRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ChangeLedColorRequest parseFrom(
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
  public static Builder newBuilder(ChangeLedColorRequest prototype) {
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
   * Protobuf type {@code ir.mahmoud.iot_attendance_system.ChangeLedColorRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ir.mahmoud.iot_attendance_system.ChangeLedColorRequest)
      ChangeLedColorRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ChangeLedColorRequest.class, Builder.class);
    }

    // Construct using com.example.iot_app.proto.ChangeLedColorRequest.newBuilder()
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
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      deviceId_ = "";

      red_ = 0;

      green_ = 0;

      blue_ = 0;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MyServiceProto.internal_static_ir_mahmoud_iot_attendance_system_ChangeLedColorRequest_descriptor;
    }

    @Override
    public ChangeLedColorRequest getDefaultInstanceForType() {
      return ChangeLedColorRequest.getDefaultInstance();
    }

    @Override
    public ChangeLedColorRequest build() {
      ChangeLedColorRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public ChangeLedColorRequest buildPartial() {
      ChangeLedColorRequest result = new ChangeLedColorRequest(this);
      result.deviceId_ = deviceId_;
      result.red_ = red_;
      result.green_ = green_;
      result.blue_ = blue_;
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
      if (other instanceof ChangeLedColorRequest) {
        return mergeFrom((ChangeLedColorRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ChangeLedColorRequest other) {
      if (other == ChangeLedColorRequest.getDefaultInstance()) return this;
      if (!other.getDeviceId().isEmpty()) {
        deviceId_ = other.deviceId_;
        onChanged();
      }
      if (other.getRed() != 0) {
        setRed(other.getRed());
      }
      if (other.getGreen() != 0) {
        setGreen(other.getGreen());
      }
      if (other.getBlue() != 0) {
        setBlue(other.getBlue());
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
      ChangeLedColorRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ChangeLedColorRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object deviceId_ = "";
    /**
     * <code>string device_id = 1;</code>
     * @return The deviceId.
     */
    public String getDeviceId() {
      Object ref = deviceId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        deviceId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string device_id = 1;</code>
     * @return The bytes for deviceId.
     */
    public com.google.protobuf.ByteString
        getDeviceIdBytes() {
      Object ref = deviceId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        deviceId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string device_id = 1;</code>
     * @param value The deviceId to set.
     * @return This builder for chaining.
     */
    public Builder setDeviceId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      deviceId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string device_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeviceId() {
      
      deviceId_ = getDefaultInstance().getDeviceId();
      onChanged();
      return this;
    }
    /**
     * <code>string device_id = 1;</code>
     * @param value The bytes for deviceId to set.
     * @return This builder for chaining.
     */
    public Builder setDeviceIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      deviceId_ = value;
      onChanged();
      return this;
    }

    private int red_ ;
    /**
     * <code>int32 red = 2;</code>
     * @return The red.
     */
    @Override
    public int getRed() {
      return red_;
    }
    /**
     * <code>int32 red = 2;</code>
     * @param value The red to set.
     * @return This builder for chaining.
     */
    public Builder setRed(int value) {
      
      red_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 red = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRed() {
      
      red_ = 0;
      onChanged();
      return this;
    }

    private int green_ ;
    /**
     * <code>int32 green = 3;</code>
     * @return The green.
     */
    @Override
    public int getGreen() {
      return green_;
    }
    /**
     * <code>int32 green = 3;</code>
     * @param value The green to set.
     * @return This builder for chaining.
     */
    public Builder setGreen(int value) {
      
      green_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 green = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearGreen() {
      
      green_ = 0;
      onChanged();
      return this;
    }

    private int blue_ ;
    /**
     * <code>int32 blue = 4;</code>
     * @return The blue.
     */
    @Override
    public int getBlue() {
      return blue_;
    }
    /**
     * <code>int32 blue = 4;</code>
     * @param value The blue to set.
     * @return This builder for chaining.
     */
    public Builder setBlue(int value) {
      
      blue_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 blue = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlue() {
      
      blue_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:ir.mahmoud.iot_attendance_system.ChangeLedColorRequest)
  }

  // @@protoc_insertion_point(class_scope:ir.mahmoud.iot_attendance_system.ChangeLedColorRequest)
  private static final ChangeLedColorRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ChangeLedColorRequest();
  }

  public static ChangeLedColorRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChangeLedColorRequest>
      PARSER = new com.google.protobuf.AbstractParser<ChangeLedColorRequest>() {
    @Override
    public ChangeLedColorRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChangeLedColorRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChangeLedColorRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<ChangeLedColorRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public ChangeLedColorRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

