package com.example.iot_app.data.server

import com.example.iot_app.data.model.AdminCommand
import com.example.iot_app.data.model.CommandResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("admin_command/")
    suspend fun sendAdminCommand(@Body adminCommand: AdminCommand) : Response<CommandResponse>



}