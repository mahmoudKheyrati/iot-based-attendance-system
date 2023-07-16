# IoT-based Attendance System

This repository contains the code for the IoT-based Attendance System developed as a part of the Bachelor's Project by MahmoudReza KheyratiFard under the supervision of Dr. Ziarati. The system incorporates an Arduino ESP32, RFID cards, and a suite of software tools including Golang, ScyllaDB, MQTT, and Docker to create a robust and real-time attendance tracking solution.

## Overview
The IoT-based attendance system is a sophisticated solution for tracking attendance using RFID cards and a set of IoT devices. The hardware components include an Arduino ESP32, an LCD monitor, a relay, and an RGB LED. The system communicates with an EMQX MQTT broker, relaying messages to a backend implemented in Golang, which connects to a NoSQL ScyllaDB database. The system also incorporates an Android app that provides real-time updates on employee presence, a log of door access, LED status, and remote door access for admin users.

## Components
The system is composed of several components:

**Arduino:** This includes an Arduino board, an RFID sensor, an LCD monitor, and an RGB LED.
**Backend Application:** This application, written in Golang, processes data and manages system functionality.
**ScyllaDB Database:** The system uses a ScyllaDB database, a highly scalable NoSQL database, to store and manage attendance data. The database is containerized using Docker for easy deployment.
**Deployment:** The deployment folder contains Docker Compose files for setting up the MQTT broker and ScyllaDB.
**Android Application:** This provides real-time system status updates, door access control, and a list of present individuals in the company.

## Repository Structure
The repository is structured as follows:

**/arduino:** Contains the Arduino sketches and schematics for the hardware setup.
**/backend:** Contains the Golang application code and Docker files.
**/android-app:** Contains the Kotlin source code for the Android application.
**/deployment:** Contains Docker Compose files for setting up the MQTT broker and ScyllaDB.

# Prerequisites
Docker and Docker-compose
Go
Android Studio
Arduino IDE

# Installation & Usage
Firstly, clone the repository to your local machine. Ensure all prerequisites mentioned above are installed and configured properly on your machine. Then, you can start by deploying the MQTT broker and ScyllaDB using the Docker Compose file located in the /deployment folder. Once the broker and database are up and running, you can upload the Arduino code to the ESP32 and run the backend application. Lastly, install the Android application on your device. Detailed instructions on each step are provided in the respective directories.

# Testing and Validation
We perform multiple levels of testing including RFID Card Verification, Real-time Monitoring of Present Individuals, LED Status and Control, and Logging of Entry Times.

# Contact
Should you have any questions, issues, or suggestions, please feel free to open an issue here, or send an email to mahmoud.kheyrati.fard@gmail.com.

