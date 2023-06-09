# todo: use go mod tidy instead of vendor
FROM golang:1.20 as builder
RUN mkdir -p /application
RUN mkdir /build
WORKDIR /application
COPY server ./
RUN go build -trimpath -mod=vendor -a -ldflags '-s -w'  -o /build/cli ./cmd/cli/main.go


FROM golang:1.20
RUN mkdir -p /application
WORKDIR /application
COPY --from=builder /build/server ./server
ENTRYPOINT ["./cli"]

