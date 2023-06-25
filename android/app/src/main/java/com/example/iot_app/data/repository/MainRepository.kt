package com.example.iot_app.data.repository

import com.example.iot_app.data.model.AdminCommand
import com.example.iot_app.data.model.CommandResponse
import com.example.iot_app.data.server.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun sendAdminCommand(adminCommand: AdminCommand): Flow<Response<CommandResponse>> {
        return flow {
            emit(apiService.sendAdminCommand(adminCommand))
        }.flowOn(Dispatchers.IO)
    }
}