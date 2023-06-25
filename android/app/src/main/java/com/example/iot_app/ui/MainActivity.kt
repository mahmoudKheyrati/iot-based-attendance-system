package com.example.iot_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.iot_app.R

import com.example.iot_app.databinding.MainActivityBinding
import com.example.iot_app.proto.ChangeLedColorRequest
import com.example.iot_app.proto.ChangeLedColorResponse
import com.example.iot_app.proto.EmployeePresenceStatusRequest
import com.example.iot_app.proto.EmployeePresenceStatusResponse
import com.example.iot_app.proto.LedColorRequest
import com.example.iot_app.proto.LedColorResponse
import com.example.iot_app.proto.OpenDoorRequest
import com.example.iot_app.proto.OpenDoorResponse
import com.example.iot_app.proto.attendanceSystemGrpc
import com.example.iot_app.utils.CheckConnection
import com.example.iot_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.grpc.ManagedChannelBuilder
import javax.inject.Inject

import io.grpc.stub.StreamObserver


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var binding: MainActivityBinding

    val userStatus = HashMap<String, String>()
    private val viewModel:MainViewModel by viewModels()


    @Inject
    lateinit var connection:CheckConnection


    var RED_BUTTON_CLICKED = false
    var GREEN_BUTTON_CLICKED = false
    var BLUE_BUTTON_CLICKED = false


    // create a new MutableLiveData object
    val roomLiveData = MutableLiveData<Map<String, String>>()

// observe changes to the LiveData and update the TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        checkInternetConnection()


        roomLiveData.observe(this, Observer { dict ->
            binding.logText.setText("")
            for((key,value )in dict){
                if(value=="true"){
                    binding.logText.append(key+"\n")
                }

            }
        })



        //grpc settings
        val channel = ManagedChannelBuilder.forAddress("192.168.43.2", 3498)
            .usePlaintext()
            .build()

        val stub  = attendanceSystemGrpc.newStub(channel)


        //led color response observer
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

            }

            override fun onCompleted() {

            }

        })

        stub.employeesPresenceStatus(EmployeePresenceStatusRequest.newBuilder().setDeviceId("42564aa8-2119-4ad9-b430-5ad89d90bf75").build(),object :StreamObserver<EmployeePresenceStatusResponse?>{
            override fun onNext(value: EmployeePresenceStatusResponse?) {

                val v = value!!
                var fullName = v.firstName+" "+v.lastName
                userStatus.put(fullName, v.isPresent.toString())
                roomLiveData.postValue(userStatus)




        }
            override fun onError(t: Throwable?) {

            }

            override fun onCompleted() {

            }

        })

        
        binding.apply {

            //open door request
            btnOpenDoor.setOnClickListener {
                stub.openDoor(OpenDoorRequest.newBuilder().setDeviceId("42564aa8-2119-4ad9-b430-5ad89d90bf75").build(),object :StreamObserver<OpenDoorResponse?>{
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

                    var r = if(RED_BUTTON_CLICKED) 1 else 0
                    var g = if(GREEN_BUTTON_CLICKED) 1 else 0
                    var b = if(BLUE_BUTTON_CLICKED) 1 else 0

                    //change led color request
                    stub.changeLedColor(
                        ChangeLedColorRequest.newBuilder().setRed(r).setGreen(g).setBlue(b).setDeviceId("42564aa8-2119-4ad9-b430-5ad89d90bf75").build(), object : StreamObserver<ChangeLedColorResponse?> {
                            override fun onNext(value: ChangeLedColorResponse?) {
                            }
                            override fun onError(t: Throwable?) {
                            }
                            override fun onCompleted() {
                            }
                        }
                    )

                }
            }




        }


    }

    private fun checkInternetConnection() {
        connection.observe(this){
            if(!it){
                Toast.makeText(this,"Check Your Internet Connection!",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Network Connected",Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun setFinalLightColor(){
        binding.apply {
            var r = if(RED_BUTTON_CLICKED) 255 else 0
            var g = if(GREEN_BUTTON_CLICKED) 255 else 0
            var b = if(BLUE_BUTTON_CLICKED) 255 else 0
            btnSetLightColor.setBackgroundColor(Color.argb(255,r,g,b) )
        }
    }


}



