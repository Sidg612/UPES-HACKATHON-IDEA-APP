package com.writetosid.suvidha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_handler_details.*

class HandlerDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_handler_details)

        val bundle = this.getIntent().getExtras()
        val pic = bundle!!.getInt("imageH")
        imageTV.setImageResource(pic)







    }
}
