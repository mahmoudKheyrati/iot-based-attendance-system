package main

import (
	"github.com/urfave/cli/v2"
	"log"
	"os"
	"time"
)

func main() {
	createDeviceCommand := &cli.Command{
		Name:      "create-device",
		Aliases:   []string{"c"},
		Usage:     "create and register new device",
		ArgsUsage: "",
		Flags: []cli.Flag{&cli.StringFlag{
			Name:        "",
			Category:    "",
			DefaultText: "",
			FilePath:    "",
			Usage:       "",
			Required:    false,
			Hidden:      false,
			HasBeenSet:  false,
			Value:       "",
			Destination: nil,
			Aliases:     nil,
			EnvVars:     nil,
			TakesFile:   false,
			Action:      nil,
		}},
		Action: func(context *cli.Context) error {

			return nil
		},
	}

	app := &cli.App{
		Name:                 "server-cli",
		Usage:                "handy cli for manging iot-based attendance system",
		Commands:             []*cli.Command{createDeviceCommand},
		EnableBashCompletion: true,
		//Action: func(context *cli.Context) error {
		//	fmt.Println(context.App.Usage)
		//	return nil
		//},
		Compiled: time.Now(),
		Authors: []*cli.Author{{
			Name:  "mahmoud reza kheyrati fard",
			Email: "mahmoud.kheyrati.fard@gmail.com",
		}},
	}

	if err := app.Run(os.Args); err != nil {
		log.Fatal(err)
	}
}
