package com.writetosid.suvidha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val background = object :Thread(){

            override fun run() {

                try {

                    Thread.sleep(3000)

                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))

                }catch (e:Exception){

                    e.printStackTrace()
                }
            }
        }
    }
}
