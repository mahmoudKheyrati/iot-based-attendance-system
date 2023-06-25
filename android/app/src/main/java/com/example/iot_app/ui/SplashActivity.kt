package com.example.iot_app.ui


import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.iot_app.R
import com.example.iot_app.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val fadein_anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val rotate_anim = AnimationUtils.loadAnimation(this, R.anim.rotate)

        binding.apply {
            logoText.startAnimation(fadein_anim)
            dbImage.startAnimation(rotate_anim)
            appImage.startAnimation(rotate_anim)
            hardwareImage.startAnimation(rotate_anim)
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(2500)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}