package com.example.iot_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.iot_app.R

import com.example.iot_app.databinding.MainActivityBinding
import com.example.iot_app.utils.CheckConnection
import com.example.iot_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


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







        binding.apply {

            //Door
            btnOpenDoor.setOnClickListener {

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
                    checkConnectionAndSendRequest()
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
}

