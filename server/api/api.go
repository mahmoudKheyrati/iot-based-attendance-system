package api

import (
	"context"
	"errors"
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"log"
	"server/config"
	"server/pkg/db"
	mqtt2 "server/pkg/mqtt"
	"server/proto/gen/pb-go/iot/attendance_system"
	"time"
)

type AttendanceSystemConfig struct {
	AdminCommandLogRepo *db.AdminCommandLogRepo
	AttendanceLogRepo   *db.AttendanceLogRepo
	DeviceRepo          *db.DeviceRepo
	DeviceStartupRepo   *db.DeviceStartupRepo
	DeviceStateLogRepo  *db.DeviceStateLogRepo
	EmployeeRepo        *db.EmployeeRepo
	LockOpenedLogRepo   *db.LockOpenedLogRepo
	MqttPublisherClient mqtt.Client
	Config              *config.Config
}
type AttendanceSystem struct {
	attendance_system.UnimplementedAttendanceSystemServer
	AttendanceSystemConfig
}

func NewAttendanceSystem(attendanceSystemConfig AttendanceSystemConfig) *AttendanceSystem {
	return &AttendanceSystem{AttendanceSystemConfig: attendanceSystemConfig}
}

func (a *AttendanceSystem) LedColor(request *attendance_system.LedColorRequest, server attendance_system.AttendanceSystem_LedColorServer) error {
	ticker := time.NewTicker(500 * time.Millisecond)
	var lastRed int32
	var lastGreen int32
	var lastBlue int32
	var isFirstRun = true
	for {
		select {
		case <-server.Context().Done():
			return nil
		case <-ticker.C:
			state, err := a.DeviceStateLogRepo.GetLatestStateByDeviceID(request.DeviceId)
			if err != nil {
				log.Println(err)
				return errors.New("internal server error")
			}
			var red int32
			var green int32
			var blue int32
			if state.LedRed {
				red = 1
			}
			if state.LedGreen {
				green = 1
			}
			if state.LedBlue {
				blue = 1
			}
			if isFirstRun || red != lastRed || green != lastGreen || blue != lastBlue {
				err = server.Send(&attendance_system.LedColorResponse{
					Red:   red,
					Green: green,
					Blue:  blue,
				})
				isFirstRun = false
				lastRed = red
				lastGreen = green
				lastBlue = blue
			}
			if err != nil {
				log.Println(err)
				return errors.New("can not send response to client")
			}

		}

	}
}

func (a *AttendanceSystem) LockOpenedHistory(request *attendance_system.LockOpenedHistoryRequest, server attendance_system.AttendanceSystem_LockOpenedHistoryServer) error {
	ticker := time.NewTicker(5 * time.Second)
	lastCount := 0
	for {
		select {
		case <-server.Context().Done():
			return nil
		case <-ticker.C:
			logs, err := a.LockOpenedLogRepo.GetByDeviceID(request.DeviceId)
			if err != nil {
				return errors.New("internal server error")
			}
			if len(logs) != lastCount {
				lastCount = len(logs)
				response := attendance_system.LockOpenedHistoryResponse{}
				for _, openedLog := range logs {
					response.Histories = append(response.Histories, &attendance_system.LockOpenedHistoryResponseHistory{
						ServerTimestamp:     openedLog.ServerTimestamp.Unix(),
						TimeAfterStartupSec: int32(openedLog.TimeAfterStartupSec),
					})
				}
				err := server.Send(&response)
				if err != nil {
					log.Println(err)
					return errors.New("can not send response to client!")
				}
			}
		}
	}
}

func (a *AttendanceSystem) ChangeLedColor(ctx context.Context, request *attendance_system.ChangeLedColorRequest) (*attendance_system.ChangeLedColorResponse, error) {
	payloadLedChangeColor := fmt.Sprintf("%d,LED_CHANGE_COLOR_%d%d%d", time.Now().Unix(), request.Red, request.Green, request.Blue)

	err := a.AdminCommandLogRepo.Insert(db.AdminCommandLog{
		DeviceID:       request.DeviceId,
		Command:        "change_led_color",
		AdminUsername:  "admin", // todo: fix that
		CommandPayload: payloadLedChangeColor,
		Timestamp:      time.Now(),
	})
	if err != nil {
		log.Println(err)
		return nil, errors.New("internal server error")
	}
	token := a.MqttPublisherClient.Publish(fmt.Sprintf("%s/%s", a.Config.TopicNames.AdminCommand, request.DeviceId), mqtt2.ExactlyOnce, false, payloadLedChangeColor)
	token.Wait()
	if err := token.Error(); err != nil {
		return nil, errors.New("led color not changed")
	}

	return &attendance_system.ChangeLedColorResponse{}, nil
}

func (a *AttendanceSystem) OpenDoor(ctx context.Context, request *attendance_system.OpenDoorRequest) (*attendance_system.OpenDoorResponse, error) {
	payloadOpenDoor := fmt.Sprintf("%d,%s", time.Now().Unix(), "LOCK_OPEN_PERMITTED")

	err := a.AdminCommandLogRepo.Insert(db.AdminCommandLog{
		DeviceID:       request.DeviceId,
		Command:        "open_door",
		AdminUsername:  "admin", // todo: fix that
		CommandPayload: payloadOpenDoor,
		Timestamp:      time.Now(),
	})
	if err != nil {
		log.Println(err)
		return nil, errors.New("internal server error")
	}

	token := a.MqttPublisherClient.Publish(fmt.Sprintf("%s/%s", a.Config.TopicNames.AdminCommand, request.DeviceId), mqtt2.ExactlyOnce, false, payloadOpenDoor)
	token.Wait()
	if err := token.Error(); err != nil {
		return nil, errors.New("door not opened")
	}
	return &attendance_system.OpenDoorResponse{}, nil

}

func (a *AttendanceSystem) GetAllDeviceIds(ctx context.Context, request *attendance_system.GetDeviceIdsRequest) (*attendance_system.GetDeviceIdsResponse, error) {
	devices, err := a.DeviceRepo.GetAllDevices()
	if err != nil {
		return nil, errors.New("internal server error")
	}
	response := attendance_system.GetDeviceIdsResponse{}
	for _, device := range devices {
		response.Devices = append(response.Devices, &attendance_system.Device{DeviceId: device.ID.String()})
	}
	return &response, nil
}

func (a *AttendanceSystem) GetAllPresentPersons(ctx context.Context, request *attendance_system.GetPresentEmployeeRequest) (*attendance_system.GetPresentEmployeeResponse, error) {
	//TODO spark
	panic("implement me")
}
