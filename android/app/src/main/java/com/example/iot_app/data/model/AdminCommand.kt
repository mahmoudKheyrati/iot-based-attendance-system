package com.example.iot_app.data.model

data class AdminCommand(
    val deviceId:String,
    val command:String,
    val R:Int,
    val G :Int,
    val B:Int
)
