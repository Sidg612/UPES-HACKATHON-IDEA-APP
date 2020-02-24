package com.writetosid.suvidha

import android.content.Intent
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.RecylerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.centre_panel.*

class MainActivity : AppCompatActivity() {

   val handlerlist= arrayListOf<Handler>()

    private val onItemClicked = object :MovieItemClickListener{

        override fun onItemClick(handlers: Handler) {

            val intent = Intent(this@MainActivity, HandlerDetails::class.java)
            val bundle = Bundle()
            bundle.putInt("imageH",handlers.image)
            intent.putExtras(bundle)
            intent.putExtra("name",handlers.name)
            intent.putExtra("distance",handlers.distance)
            intent.putExtra("address",handlers.address)
            startActivity(intent)

        }
    }

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handlerlist.add(Handler("ParkingLot1",3,"12, Delhi",R.drawable.parkingimg1))
        handlerlist.add(Handler("ParkingLot2",4,"13, Delhi",R.drawable.parkingimage2))
        handlerlist.add(Handler("ParkingLot3",2,"15, Delhi",R.drawable.parkingimage3))
        handlerlist.add(Handler("ParkingLot4",8,"21, Delhi",R.drawable.parkingimage4))
        handlerlist.add(Handler("ParkingLot5",1,"54, Delhi",R.drawable.parkingimage5))


        ArrayAdapter.createFromResource(this,
            R.array.Location,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerTV.adapter=adapter }

            val handlerAdapter  = HandlerAdapter(handlerlist)
            handlerAdapter.onItemClickListener = onItemClicked


            RecylerView.apply {

                layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false )

                adapter=handlerAdapter

            }
    }
}

data class Handler(

    var name:String,
    var distance: Int,
    var address:String,
    val image: Int
)


