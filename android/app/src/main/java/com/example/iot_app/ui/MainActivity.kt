package com.example.iot_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.iot_app.R

import com.example.iot_app.databinding.MainActivityBinding
import com.example.iot_app.proto.ChangeLedColorRequest
import com.example.iot_app.proto.ChangeLedColorResponse
import com.example.iot_app.proto.LedColorRequest
import com.example.iot_app.proto.LedColorResponse
import com.example.iot_app.proto.OpenDoorRequest
import com.example.iot_app.proto.OpenDoorResponse
import com.example.iot_app.utils.CheckConnection
import com.example.iot_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.io.Closeable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

import com.example.iot_app.proto.attendanceSystemGrpc
import dagger.hilt.android.HiltAndroidApp
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.coroutineScope

import java.net.Socket
import java.net.InetSocketAddress


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var binding: MainActivityBinding


    private val viewModel:MainViewModel by viewModels()


    @Inject
    lateinit var connection:CheckConnection


    var RED_BUTTON_CLICKED = false
    var GREEN_BUTTON_CLICKED = false
    var BLUE_BUTTON_CLICKED = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val ip = "192.168.43.2"
        val port = 3498

        var iplist = listOf("192.168.43.2", "172.23.0.1" ,"172.19.0.1" ,"172.18.0.1 ","172.17.0.1 ","172.20.0.1" ,"172.22.0.1 ","172.24.0.1 ","172.25.0.1")


        for (ip in iplist){
            if (checkConnectivity(ip, port)) {
                Log.e("ylog","connect to "+ip)
            } else {
                // Connection failed, handle error
                Log.e("ylog","not connect"+ip)
            }
        }







        val channel = ManagedChannelBuilder.forAddress("192.168.43.2", 3498)
            .usePlaintext()
            .build()



        val stub  =attendanceSystemGrpc.newStub(channel)


        stub.ledColor(LedColorRequest.newBuilder().setDeviceId("42564aa8-2119-4ad9-b430-5ad89d90bf75").build(),object :StreamObserver<LedColorResponse?>{
            override fun onNext(value: LedColorResponse?) {



                    var r = value!!.red*255
                    var g = value!!.green*255
                    var b = value!!.blue*255
                    binding.apply {
                        currentLightColor.setBackgroundColor(Color.argb(255,r,g,b) )
                    }



            }

            override fun onError(t: Throwable?) {

                print("")
            }

            override fun onCompleted() {

                print("")
            }

        })








        binding.apply {

            //Door
            btnOpenDoor.setOnClickListener {
                stub.openDoor(OpenDoorRequest.newBuilder().setDeviceId("42564aa8-2119-4ad9-b430-5ad89d90bf75").build(),object : StreamObserver<OpenDoorResponse?>{
                    override fun onNext(value: OpenDoorResponse?) {

                    }

                    override fun onError(t: Throwable?) {

                    }

                    override fun onCompleted() {

                    }

                })

            }


            //RGB Light

            //RED
            btnRedLight.run {
                setOnClickListener {
                    RED_BUTTON_CLICKED = if(RED_BUTTON_CLICKED){
                        setBackgroundResource(R.drawable.bg_button_red_light)
                        false
                    } else {
                        setBackgroundResource(R.drawable.bg_button_red_onclick)
                        true

                    }
                    setFinalLightColor()
                }
            }

            //GREEN
            btnGreenLight.run {
                setOnClickListener {
                    GREEN_BUTTON_CLICKED = if(GREEN_BUTTON_CLICKED){
                        setBackgroundResource(R.drawable.bg_button_green_light)
                        false
                    } else {
                        setBackgroundResource(R.drawable.bg_button_green_onclick)
                        true

                    }
                    setFinalLightColor()
                }
            }

            //BLUE
            btnBlueLight.run {
                setOnClickListener {



                    BLUE_BUTTON_CLICKED = if(BLUE_BUTTON_CLICKED){
                        setBackgroundResource(R.drawable.bg_button_blue_light)
                        false
                    } else {
                        setBackgroundResource(R.drawable.bg_button_blue_onclick)
                        true

                    }
                    setFinalLightColor()
                }
            }


            btnSetLightColor.run {
                setOnClickListener {
                    //checkConnectionAndSendRequest()


                    var r = if(RED_BUTTON_CLICKED) 1 else 0
                    var g = if(GREEN_BUTTON_CLICKED) 1 else 0
                    var b = if(BLUE_BUTTON_CLICKED) 1 else 0


                    stub.changeLedColor(
                        ChangeLedColorRequest.newBuilder().setRed(r).setGreen(g).setBlue(b).setDeviceId("42564aa8-2119-4ad9-b430-5ad89d90bf75").build(), object : StreamObserver<ChangeLedColorResponse?> {
                            override fun onNext(value: ChangeLedColorResponse?) {
                                print("")

                            }

                            override fun onError(t: Throwable?) {
                                Log.e("yyy",t?.message.toString())

                            }

                            override fun onCompleted() {
                                print("")
                            }
                        }
                    )

                }
            }


        }


    }

    private fun checkConnectionAndSendRequest() {
        connection.observe(this){
            //grpc codes
        }
    }


    fun setFinalLightColor(){
        binding.apply {
            var r = if(RED_BUTTON_CLICKED) 255 else 0
            var g = if(GREEN_BUTTON_CLICKED) 255 else 0
            var b = if(BLUE_BUTTON_CLICKED) 255 else 0
            finalLightColor.setBackgroundColor(Color.argb(255,r,g,b) )
        }
    }



    fun checkConnectivity(ip: String, port: Int): Boolean {

        return try {
            val socket = Socket()
            socket.connect(InetSocketAddress(ip, port), 5000) // 5000ms timeout
            socket.close()
            true
        } catch (e: Exception) {
            false
        }
    }









}



