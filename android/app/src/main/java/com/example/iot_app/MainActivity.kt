package com.example.iot_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color

import com.example.iot_app.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding
    //var rgb_state = "000"

    var RED_BUTTON_CLICKED = false
    var GREEN_BUTTON_CLICKED = false
    var BLUE_BUTTON_CLICKED = false

    var LIGHT_COLOR = "000"

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

                }
            }


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

