package main

import (
	"fmt"
	"server/config"
)

func main() {
	c := config.NewConfig()

	fmt.Printf("config: %+v", c)

}
