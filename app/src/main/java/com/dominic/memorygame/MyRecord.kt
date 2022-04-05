package com.dominic.memorygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_my_record.*

class MyRecord : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_record)


       check()

        restsrt_the_game.setOnClickListener {
            val intent = Intent(this,Game::class.java)
            startActivity(intent)
        }
    }
    @SuppressLint("SetTextI18n")
    fun check()
    {
        val getRecord:Record = intent.getSerializableExtra("rc") as Record
        if (getRecord.record != "6")
        {
            record_me.text = "Your Record: ${getRecord.record}"


        }else
        {
            record_me.isAllCaps = true
            record_me.text = "You're Winner: ${getRecord.record}"
            val animation = AnimationUtils.loadAnimation(this,R.anim.winner)
            rm.startAnimation(animation)



        }

    }
}