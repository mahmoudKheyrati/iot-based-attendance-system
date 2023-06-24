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
  private static volatile io.grpc.MethodDescriptor<LedColorRequest,
      LedColorResponse> getLedColorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ledColor",
      requestType = LedColorRequest.class,
      responseType = LedColorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<LedColorRequest,
      LedColorResponse> getLedColorMethod() {
    io.grpc.MethodDescriptor<LedColorRequest, LedColorResponse> getLedColorMethod;
    if ((getLedColorMethod = attendanceSystemGrpc.getLedColorMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getLedColorMethod = attendanceSystemGrpc.getLedColorMethod) == null) {
          attendanceSystemGrpc.getLedColorMethod = getLedColorMethod =
              io.grpc.MethodDescriptor.<LedColorRequest, LedColorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ledColor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LedColorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LedColorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("ledColor"))
              .build();
        }
      }
    }
    return getLedColorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LockOpenedHistoryRequest,
      LockOpenedHistoryResponse> getLockOpenedHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lockOpenedHistory",
      requestType = LockOpenedHistoryRequest.class,
      responseType = LockOpenedHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<LockOpenedHistoryRequest,
      LockOpenedHistoryResponse> getLockOpenedHistoryMethod() {
    io.grpc.MethodDescriptor<LockOpenedHistoryRequest, LockOpenedHistoryResponse> getLockOpenedHistoryMethod;
    if ((getLockOpenedHistoryMethod = attendanceSystemGrpc.getLockOpenedHistoryMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getLockOpenedHistoryMethod = attendanceSystemGrpc.getLockOpenedHistoryMethod) == null) {
          attendanceSystemGrpc.getLockOpenedHistoryMethod = getLockOpenedHistoryMethod =
              io.grpc.MethodDescriptor.<LockOpenedHistoryRequest, LockOpenedHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "lockOpenedHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LockOpenedHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LockOpenedHistoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("lockOpenedHistory"))
              .build();
        }
      }
    }
    return getLockOpenedHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChangeLedColorRequest,
      ChangeLedColorResponse> getChangeLedColorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeLedColor",
      requestType = ChangeLedColorRequest.class,
      responseType = ChangeLedColorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChangeLedColorRequest,
      ChangeLedColorResponse> getChangeLedColorMethod() {
    io.grpc.MethodDescriptor<ChangeLedColorRequest, ChangeLedColorResponse> getChangeLedColorMethod;
    if ((getChangeLedColorMethod = attendanceSystemGrpc.getChangeLedColorMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getChangeLedColorMethod = attendanceSystemGrpc.getChangeLedColorMethod) == null) {
          attendanceSystemGrpc.getChangeLedColorMethod = getChangeLedColorMethod =
              io.grpc.MethodDescriptor.<ChangeLedColorRequest, ChangeLedColorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "changeLedColor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeLedColorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeLedColorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("changeLedColor"))
              .build();
        }
      }
    }
    return getChangeLedColorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OpenDoorRequest,
      OpenDoorResponse> getOpenDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "openDoor",
      requestType = OpenDoorRequest.class,
      responseType = OpenDoorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OpenDoorRequest,
      OpenDoorResponse> getOpenDoorMethod() {
    io.grpc.MethodDescriptor<OpenDoorRequest, OpenDoorResponse> getOpenDoorMethod;
    if ((getOpenDoorMethod = attendanceSystemGrpc.getOpenDoorMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getOpenDoorMethod = attendanceSystemGrpc.getOpenDoorMethod) == null) {
          attendanceSystemGrpc.getOpenDoorMethod = getOpenDoorMethod =
              io.grpc.MethodDescriptor.<OpenDoorRequest, OpenDoorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "openDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OpenDoorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OpenDoorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("openDoor"))
              .build();
        }
      }
    }
    return getOpenDoorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetDeviceIdsRequest,
      GetDeviceIdsResponse> getGetAllDeviceIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllDeviceIds",
      requestType = GetDeviceIdsRequest.class,
      responseType = GetDeviceIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetDeviceIdsRequest,
      GetDeviceIdsResponse> getGetAllDeviceIdsMethod() {
    io.grpc.MethodDescriptor<GetDeviceIdsRequest, GetDeviceIdsResponse> getGetAllDeviceIdsMethod;
    if ((getGetAllDeviceIdsMethod = attendanceSystemGrpc.getGetAllDeviceIdsMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getGetAllDeviceIdsMethod = attendanceSystemGrpc.getGetAllDeviceIdsMethod) == null) {
          attendanceSystemGrpc.getGetAllDeviceIdsMethod = getGetAllDeviceIdsMethod =
              io.grpc.MethodDescriptor.<GetDeviceIdsRequest, GetDeviceIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllDeviceIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetDeviceIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetDeviceIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("getAllDeviceIds"))
              .build();
        }
      }
    }
    return getGetAllDeviceIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<EmployeePresenceStatusRequest,
      EmployeePresenceStatusResponse> getEmployeesPresenceStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "employeesPresenceStatus",
      requestType = EmployeePresenceStatusRequest.class,
      responseType = EmployeePresenceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<EmployeePresenceStatusRequest,
      EmployeePresenceStatusResponse> getEmployeesPresenceStatusMethod() {
    io.grpc.MethodDescriptor<EmployeePresenceStatusRequest, EmployeePresenceStatusResponse> getEmployeesPresenceStatusMethod;
    if ((getEmployeesPresenceStatusMethod = attendanceSystemGrpc.getEmployeesPresenceStatusMethod) == null) {
      synchronized (attendanceSystemGrpc.class) {
        if ((getEmployeesPresenceStatusMethod = attendanceSystemGrpc.getEmployeesPresenceStatusMethod) == null) {
          attendanceSystemGrpc.getEmployeesPresenceStatusMethod = getEmployeesPresenceStatusMethod =
              io.grpc.MethodDescriptor.<EmployeePresenceStatusRequest, EmployeePresenceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "employeesPresenceStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmployeePresenceStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmployeePresenceStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new attendanceSystemMethodDescriptorSupplier("employeesPresenceStatus"))
              .build();
        }
      }
    }
    return getEmployeesPresenceStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static attendanceSystemStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<attendanceSystemStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<attendanceSystemStub>() {
        @Override
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
        @Override
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
        @Override
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
    public void ledColor(LedColorRequest request,
                         io.grpc.stub.StreamObserver<LedColorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLedColorMethod(), responseObserver);
    }

    /**
     */
    public void lockOpenedHistory(LockOpenedHistoryRequest request,
                                  io.grpc.stub.StreamObserver<LockOpenedHistoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLockOpenedHistoryMethod(), responseObserver);
    }

    /**
     */
    public void changeLedColor(ChangeLedColorRequest request,
                               io.grpc.stub.StreamObserver<ChangeLedColorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeLedColorMethod(), responseObserver);
    }

    /**
     */
    public void openDoor(OpenDoorRequest request,
                         io.grpc.stub.StreamObserver<OpenDoorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenDoorMethod(), responseObserver);
    }

    /**
     */
    public void getAllDeviceIds(GetDeviceIdsRequest request,
                                io.grpc.stub.StreamObserver<GetDeviceIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllDeviceIdsMethod(), responseObserver);
    }

    /**
     */
    public void employeesPresenceStatus(EmployeePresenceStatusRequest request,
                                        io.grpc.stub.StreamObserver<EmployeePresenceStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEmployeesPresenceStatusMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLedColorMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                LedColorRequest,
                LedColorResponse>(
                  this, METHODID_LED_COLOR)))
          .addMethod(
            getLockOpenedHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                LockOpenedHistoryRequest,
                LockOpenedHistoryResponse>(
                  this, METHODID_LOCK_OPENED_HISTORY)))
          .addMethod(
            getChangeLedColorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ChangeLedColorRequest,
                ChangeLedColorResponse>(
                  this, METHODID_CHANGE_LED_COLOR)))
          .addMethod(
            getOpenDoorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                OpenDoorRequest,
                OpenDoorResponse>(
                  this, METHODID_OPEN_DOOR)))
          .addMethod(
            getGetAllDeviceIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetDeviceIdsRequest,
                GetDeviceIdsResponse>(
                  this, METHODID_GET_ALL_DEVICE_IDS)))
          .addMethod(
            getEmployeesPresenceStatusMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                EmployeePresenceStatusRequest,
                EmployeePresenceStatusResponse>(
                  this, METHODID_EMPLOYEES_PRESENCE_STATUS)))
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

    @Override
    protected attendanceSystemStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new attendanceSystemStub(channel, callOptions);
    }

    /**
     */
    public void ledColor(LedColorRequest request,
                         io.grpc.stub.StreamObserver<LedColorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLedColorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lockOpenedHistory(LockOpenedHistoryRequest request,
                                  io.grpc.stub.StreamObserver<LockOpenedHistoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLockOpenedHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeLedColor(ChangeLedColorRequest request,
                               io.grpc.stub.StreamObserver<ChangeLedColorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeLedColorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void openDoor(OpenDoorRequest request,
                         io.grpc.stub.StreamObserver<OpenDoorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllDeviceIds(GetDeviceIdsRequest request,
                                io.grpc.stub.StreamObserver<GetDeviceIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllDeviceIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void employeesPresenceStatus(EmployeePresenceStatusRequest request,
                                        io.grpc.stub.StreamObserver<EmployeePresenceStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getEmployeesPresenceStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class attendanceSystemBlockingStub extends io.grpc.stub.AbstractBlockingStub<attendanceSystemBlockingStub> {
    private attendanceSystemBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected attendanceSystemBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new attendanceSystemBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<LedColorResponse> ledColor(
        LedColorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLedColorMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<LockOpenedHistoryResponse> lockOpenedHistory(
        LockOpenedHistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLockOpenedHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public ChangeLedColorResponse changeLedColor(ChangeLedColorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeLedColorMethod(), getCallOptions(), request);
    }

    /**
     */
    public OpenDoorResponse openDoor(OpenDoorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenDoorMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetDeviceIdsResponse getAllDeviceIds(GetDeviceIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllDeviceIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<EmployeePresenceStatusResponse> employeesPresenceStatus(
        EmployeePresenceStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getEmployeesPresenceStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class attendanceSystemFutureStub extends io.grpc.stub.AbstractFutureStub<attendanceSystemFutureStub> {
    private attendanceSystemFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected attendanceSystemFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new attendanceSystemFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChangeLedColorResponse> changeLedColor(
        ChangeLedColorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeLedColorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<OpenDoorResponse> openDoor(
        OpenDoorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetDeviceIdsResponse> getAllDeviceIds(
        GetDeviceIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllDeviceIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LED_COLOR = 0;
  private static final int METHODID_LOCK_OPENED_HISTORY = 1;
  private static final int METHODID_CHANGE_LED_COLOR = 2;
  private static final int METHODID_OPEN_DOOR = 3;
  private static final int METHODID_GET_ALL_DEVICE_IDS = 4;
  private static final int METHODID_EMPLOYEES_PRESENCE_STATUS = 5;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LED_COLOR:
          serviceImpl.ledColor((LedColorRequest) request,
              (io.grpc.stub.StreamObserver<LedColorResponse>) responseObserver);
          break;
        case METHODID_LOCK_OPENED_HISTORY:
          serviceImpl.lockOpenedHistory((LockOpenedHistoryRequest) request,
              (io.grpc.stub.StreamObserver<LockOpenedHistoryResponse>) responseObserver);
          break;
        case METHODID_CHANGE_LED_COLOR:
          serviceImpl.changeLedColor((ChangeLedColorRequest) request,
              (io.grpc.stub.StreamObserver<ChangeLedColorResponse>) responseObserver);
          break;
        case METHODID_OPEN_DOOR:
          serviceImpl.openDoor((OpenDoorRequest) request,
              (io.grpc.stub.StreamObserver<OpenDoorResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_DEVICE_IDS:
          serviceImpl.getAllDeviceIds((GetDeviceIdsRequest) request,
              (io.grpc.stub.StreamObserver<GetDeviceIdsResponse>) responseObserver);
          break;
        case METHODID_EMPLOYEES_PRESENCE_STATUS:
          serviceImpl.employeesPresenceStatus((EmployeePresenceStatusRequest) request,
              (io.grpc.stub.StreamObserver<EmployeePresenceStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
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

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MyServiceProto.getDescriptor();
    }

    @Override
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

    @Override
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
              .addMethod(getEmployeesPresenceStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
