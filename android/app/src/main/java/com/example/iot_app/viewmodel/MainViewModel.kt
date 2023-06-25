package com.example.iot_app.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.iot_app.data.model.AdminCommand
import com.example.iot_app.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iot_app.data.model.CommandResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject  constructor(private val mainRepository: MainRepository): ViewModel(){

    val commandResponse = MutableLiveData<CommandResponse>()

    fun sendAdminCommend(adminCommand: AdminCommand){
         viewModelScope.launch{
            mainRepository.sendAdminCommand(adminCommand).collect{
                commandResponse.postValue(it.body())
            }
        }
    }
}