package com.example.iot_app.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class attendanceSystemGrpc {

  private attendanceSystemGrpc() {}

  public static final String SERVICE_NAME = "ir.mahmoud.iot_attendance_system.attendanceSystem";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.iot_app.proto.LedColorRequest,
      com.example.iot_app.proto.LedColorResponse> getLedColorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ledColor",
      requestType = com.example.iot_app.proto.LedColorRequest.class,
      responseType = com.example.iot_app.proto.LedColorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.iot_app.proto.LedColorRequest,
      com.example.iot_app.proto.LedColorResponse> getLedColorMethod() {
    io.grpc.MethodDescriptor<com.example.iot_app.proto.LedColorRequest, com.example.iot_app.proto.LedColorResponse> getLedColorMethod;
    if ((getLedColorMethod = attendanceSystemGrpc.getLedColorMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getLedColorMethod = attendanceSystemGrpc.getLedColorMethod) == null) {
          attendanceSystemGrpc.getLedColorMethod = getLedColorMethod =
              io.grpc.MethodDescriptor.<com.example.iot_app.proto.LedColorRequest, com.example.iot_app.proto.LedColorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ledColor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.LedColorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.LedColorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("ledColor"))
              .build();
        }
      }
    }
    return getLedColorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.iot_app.proto.LockOpenedHistoryRequest,
      com.example.iot_app.proto.LockOpenedHistoryResponse> getLockOpenedHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lockOpenedHistory",
      requestType = com.example.iot_app.proto.LockOpenedHistoryRequest.class,
      responseType = com.example.iot_app.proto.LockOpenedHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.iot_app.proto.LockOpenedHistoryRequest,
      com.example.iot_app.proto.LockOpenedHistoryResponse> getLockOpenedHistoryMethod() {
    io.grpc.MethodDescriptor<com.example.iot_app.proto.LockOpenedHistoryRequest, com.example.iot_app.proto.LockOpenedHistoryResponse> getLockOpenedHistoryMethod;
    if ((getLockOpenedHistoryMethod = attendanceSystemGrpc.getLockOpenedHistoryMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getLockOpenedHistoryMethod = attendanceSystemGrpc.getLockOpenedHistoryMethod) == null) {
          attendanceSystemGrpc.getLockOpenedHistoryMethod = getLockOpenedHistoryMethod =
              io.grpc.MethodDescriptor.<com.example.iot_app.proto.LockOpenedHistoryRequest, com.example.iot_app.proto.LockOpenedHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "lockOpenedHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.LockOpenedHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.LockOpenedHistoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("lockOpenedHistory"))
              .build();
        }
      }
    }
    return getLockOpenedHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.iot_app.proto.ChangeLedColorRequest,
      com.example.iot_app.proto.ChangeLedColorResponse> getChangeLedColorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeLedColor",
      requestType = com.example.iot_app.proto.ChangeLedColorRequest.class,
      responseType = com.example.iot_app.proto.ChangeLedColorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.iot_app.proto.ChangeLedColorRequest,
      com.example.iot_app.proto.ChangeLedColorResponse> getChangeLedColorMethod() {
    io.grpc.MethodDescriptor<com.example.iot_app.proto.ChangeLedColorRequest, com.example.iot_app.proto.ChangeLedColorResponse> getChangeLedColorMethod;
    if ((getChangeLedColorMethod = attendanceSystemGrpc.getChangeLedColorMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getChangeLedColorMethod = attendanceSystemGrpc.getChangeLedColorMethod) == null) {
          attendanceSystemGrpc.getChangeLedColorMethod = getChangeLedColorMethod =
              io.grpc.MethodDescriptor.<com.example.iot_app.proto.ChangeLedColorRequest, com.example.iot_app.proto.ChangeLedColorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "changeLedColor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.ChangeLedColorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.ChangeLedColorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("changeLedColor"))
              .build();
        }
      }
    }
    return getChangeLedColorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.iot_app.proto.OpenDoorRequest,
      com.example.iot_app.proto.OpenDoorResponse> getOpenDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "openDoor",
      requestType = com.example.iot_app.proto.OpenDoorRequest.class,
      responseType = com.example.iot_app.proto.OpenDoorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.iot_app.proto.OpenDoorRequest,
      com.example.iot_app.proto.OpenDoorResponse> getOpenDoorMethod() {
    io.grpc.MethodDescriptor<com.example.iot_app.proto.OpenDoorRequest, com.example.iot_app.proto.OpenDoorResponse> getOpenDoorMethod;
    if ((getOpenDoorMethod = attendanceSystemGrpc.getOpenDoorMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getOpenDoorMethod = attendanceSystemGrpc.getOpenDoorMethod) == null) {
          attendanceSystemGrpc.getOpenDoorMethod = getOpenDoorMethod =
              io.grpc.MethodDescriptor.<com.example.iot_app.proto.OpenDoorRequest, com.example.iot_app.proto.OpenDoorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "openDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.OpenDoorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.OpenDoorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("openDoor"))
              .build();
        }
      }
    }
    return getOpenDoorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.iot_app.proto.GetDeviceIdsRequest,
      com.example.iot_app.proto.GetDeviceIdsResponse> getGetAllDeviceIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllDeviceIds",
      requestType = com.example.iot_app.proto.GetDeviceIdsRequest.class,
      responseType = com.example.iot_app.proto.GetDeviceIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.iot_app.proto.GetDeviceIdsRequest,
      com.example.iot_app.proto.GetDeviceIdsResponse> getGetAllDeviceIdsMethod() {
    io.grpc.MethodDescriptor<com.example.iot_app.proto.GetDeviceIdsRequest, com.example.iot_app.proto.GetDeviceIdsResponse> getGetAllDeviceIdsMethod;
    if ((getGetAllDeviceIdsMethod = attendanceSystemGrpc.getGetAllDeviceIdsMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getGetAllDeviceIdsMethod = attendanceSystemGrpc.getGetAllDeviceIdsMethod) == null) {
          attendanceSystemGrpc.getGetAllDeviceIdsMethod = getGetAllDeviceIdsMethod =
              io.grpc.MethodDescriptor.<com.example.iot_app.proto.GetDeviceIdsRequest, com.example.iot_app.proto.GetDeviceIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllDeviceIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.GetDeviceIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.GetDeviceIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("getAllDeviceIds"))
              .build();
        }
      }
    }
    return getGetAllDeviceIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.iot_app.proto.GetPresentEmployeeRequest,
      com.example.iot_app.proto.GetPresentEmployeeResponse> getGetAllPresentPersonsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllPresentPersons",
      requestType = com.example.iot_app.proto.GetPresentEmployeeRequest.class,
      responseType = com.example.iot_app.proto.GetPresentEmployeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.iot_app.proto.GetPresentEmployeeRequest,
      com.example.iot_app.proto.GetPresentEmployeeResponse> getGetAllPresentPersonsMethod() {
    io.grpc.MethodDescriptor<com.example.iot_app.proto.GetPresentEmployeeRequest, com.example.iot_app.proto.GetPresentEmployeeResponse> getGetAllPresentPersonsMethod;
    if ((getGetAllPresentPersonsMethod = attendanceSystemGrpc.getGetAllPresentPersonsMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getGetAllPresentPersonsMethod = attendanceSystemGrpc.getGetAllPresentPersonsMethod) == null) {
          attendanceSystemGrpc.getGetAllPresentPersonsMethod = getGetAllPresentPersonsMethod =
              io.grpc.MethodDescriptor.<com.example.iot_app.proto.GetPresentEmployeeRequest, com.example.iot_app.proto.GetPresentEmployeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllPresentPersons"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.GetPresentEmployeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.iot_app.proto.GetPresentEmployeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("getAllPresentPersons"))
              .build();
        }
      }
    }
    return getGetAllPresentPersonsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static attendanceSystemStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<attendanceSystemStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<attendanceSystemStub>() {
        @java.lang.Override
        public attendanceSystemStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new attendanceSystemStub(channel, callOptions);
        }
      };
    return attendanceSystemStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static attendanceSystemBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<attendanceSystemBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<attendanceSystemBlockingStub>() {
        @java.lang.Override
        public attendanceSystemBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new attendanceSystemBlockingStub(channel, callOptions);
        }
      };
    return attendanceSystemBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static attendanceSystemFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<attendanceSystemFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<attendanceSystemFutureStub>() {
        @java.lang.Override
        public attendanceSystemFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new attendanceSystemFutureStub(channel, callOptions);
        }
      };
    return attendanceSystemFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class attendanceSystemImplBase implements io.grpc.BindableService {

    /**
     */
    public void ledColor(com.example.iot_app.proto.LedColorRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.LedColorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLedColorMethod(), responseObserver);
    }

    /**
     */
    public void lockOpenedHistory(com.example.iot_app.proto.LockOpenedHistoryRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.LockOpenedHistoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLockOpenedHistoryMethod(), responseObserver);
    }

    /**
     */
    public void changeLedColor(com.example.iot_app.proto.ChangeLedColorRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.ChangeLedColorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeLedColorMethod(), responseObserver);
    }

    /**
     */
    public void openDoor(com.example.iot_app.proto.OpenDoorRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.OpenDoorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenDoorMethod(), responseObserver);
    }

    /**
     */
    public void getAllDeviceIds(com.example.iot_app.proto.GetDeviceIdsRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.GetDeviceIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllDeviceIdsMethod(), responseObserver);
    }

    /**
     */
    public void getAllPresentPersons(com.example.iot_app.proto.GetPresentEmployeeRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.GetPresentEmployeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPresentPersonsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLedColorMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.example.iot_app.proto.LedColorRequest,
                com.example.iot_app.proto.LedColorResponse>(
                  this, METHODID_LED_COLOR)))
          .addMethod(
            getLockOpenedHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.example.iot_app.proto.LockOpenedHistoryRequest,
                com.example.iot_app.proto.LockOpenedHistoryResponse>(
                  this, METHODID_LOCK_OPENED_HISTORY)))
          .addMethod(
            getChangeLedColorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.iot_app.proto.ChangeLedColorRequest,
                com.example.iot_app.proto.ChangeLedColorResponse>(
                  this, METHODID_CHANGE_LED_COLOR)))
          .addMethod(
            getOpenDoorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.iot_app.proto.OpenDoorRequest,
                com.example.iot_app.proto.OpenDoorResponse>(
                  this, METHODID_OPEN_DOOR)))
          .addMethod(
            getGetAllDeviceIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.iot_app.proto.GetDeviceIdsRequest,
                com.example.iot_app.proto.GetDeviceIdsResponse>(
                  this, METHODID_GET_ALL_DEVICE_IDS)))
          .addMethod(
            getGetAllPresentPersonsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.iot_app.proto.GetPresentEmployeeRequest,
                com.example.iot_app.proto.GetPresentEmployeeResponse>(
                  this, METHODID_GET_ALL_PRESENT_PERSONS)))
          .build();
    }
  }

  /**
   */
  public static final class attendanceSystemStub extends io.grpc.stub.AbstractAsyncStub<attendanceSystemStub> {
    private attendanceSystemStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected attendanceSystemStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new attendanceSystemStub(channel, callOptions);
    }

    /**
     */
    public void ledColor(com.example.iot_app.proto.LedColorRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.LedColorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLedColorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lockOpenedHistory(com.example.iot_app.proto.LockOpenedHistoryRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.LockOpenedHistoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLockOpenedHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeLedColor(com.example.iot_app.proto.ChangeLedColorRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.ChangeLedColorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeLedColorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void openDoor(com.example.iot_app.proto.OpenDoorRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.OpenDoorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllDeviceIds(com.example.iot_app.proto.GetDeviceIdsRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.GetDeviceIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllDeviceIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPresentPersons(com.example.iot_app.proto.GetPresentEmployeeRequest request,
        io.grpc.stub.StreamObserver<com.example.iot_app.proto.GetPresentEmployeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllPresentPersonsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class attendanceSystemBlockingStub extends io.grpc.stub.AbstractBlockingStub<attendanceSystemBlockingStub> {
    private attendanceSystemBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected attendanceSystemBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new attendanceSystemBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.iot_app.proto.LedColorResponse> ledColor(
        com.example.iot_app.proto.LedColorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLedColorMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.iot_app.proto.LockOpenedHistoryResponse> lockOpenedHistory(
        com.example.iot_app.proto.LockOpenedHistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLockOpenedHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.iot_app.proto.ChangeLedColorResponse changeLedColor(com.example.iot_app.proto.ChangeLedColorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeLedColorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.iot_app.proto.OpenDoorResponse openDoor(com.example.iot_app.proto.OpenDoorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenDoorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.iot_app.proto.GetDeviceIdsResponse getAllDeviceIds(com.example.iot_app.proto.GetDeviceIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllDeviceIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.iot_app.proto.GetPresentEmployeeResponse getAllPresentPersons(com.example.iot_app.proto.GetPresentEmployeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllPresentPersonsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class attendanceSystemFutureStub extends io.grpc.stub.AbstractFutureStub<attendanceSystemFutureStub> {
    private attendanceSystemFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected attendanceSystemFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new attendanceSystemFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.iot_app.proto.ChangeLedColorResponse> changeLedColor(
        com.example.iot_app.proto.ChangeLedColorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeLedColorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.iot_app.proto.OpenDoorResponse> openDoor(
        com.example.iot_app.proto.OpenDoorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.iot_app.proto.GetDeviceIdsResponse> getAllDeviceIds(
        com.example.iot_app.proto.GetDeviceIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllDeviceIdsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.iot_app.proto.GetPresentEmployeeResponse> getAllPresentPersons(
        com.example.iot_app.proto.GetPresentEmployeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllPresentPersonsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LED_COLOR = 0;
  private static final int METHODID_LOCK_OPENED_HISTORY = 1;
  private static final int METHODID_CHANGE_LED_COLOR = 2;
  private static final int METHODID_OPEN_DOOR = 3;
  private static final int METHODID_GET_ALL_DEVICE_IDS = 4;
  private static final int METHODID_GET_ALL_PRESENT_PERSONS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final attendanceSystemImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(attendanceSystemImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LED_COLOR:
          serviceImpl.ledColor((com.example.iot_app.proto.LedColorRequest) request,
              (io.grpc.stub.StreamObserver<com.example.iot_app.proto.LedColorResponse>) responseObserver);
          break;
        case METHODID_LOCK_OPENED_HISTORY:
          serviceImpl.lockOpenedHistory((com.example.iot_app.proto.LockOpenedHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.iot_app.proto.LockOpenedHistoryResponse>) responseObserver);
          break;
        case METHODID_CHANGE_LED_COLOR:
          serviceImpl.changeLedColor((com.example.iot_app.proto.ChangeLedColorRequest) request,
              (io.grpc.stub.StreamObserver<com.example.iot_app.proto.ChangeLedColorResponse>) responseObserver);
          break;
        case METHODID_OPEN_DOOR:
          serviceImpl.openDoor((com.example.iot_app.proto.OpenDoorRequest) request,
              (io.grpc.stub.StreamObserver<com.example.iot_app.proto.OpenDoorResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_DEVICE_IDS:
          serviceImpl.getAllDeviceIds((com.example.iot_app.proto.GetDeviceIdsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.iot_app.proto.GetDeviceIdsResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_PRESENT_PERSONS:
          serviceImpl.getAllPresentPersons((com.example.iot_app.proto.GetPresentEmployeeRequest) request,
              (io.grpc.stub.StreamObserver<com.example.iot_app.proto.GetPresentEmployeeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class attendanceSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    attendanceSystemBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.iot_app.proto.MyServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("attendanceSystem");
    }
  }

  private static final class attendanceSystemFileDescriptorSupplier
      extends attendanceSystemBaseDescriptorSupplier {
    attendanceSystemFileDescriptorSupplier() {}
  }

  private static final class attendanceSystemMethodDescriptorSupplier
      extends attendanceSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    attendanceSystemMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (attendanceSystemGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new attendanceSystemFileDescriptorSupplier())
              .addMethod(getLedColorMethod())
              .addMethod(getLockOpenedHistoryMethod())
              .addMethod(getChangeLedColorMethod())
              .addMethod(getOpenDoorMethod())
              .addMethod(getGetAllDeviceIdsMethod())
              .addMethod(getGetAllPresentPersonsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
