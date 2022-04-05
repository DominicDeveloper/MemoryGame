package com.dominic.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startGame.setOnClickListener {
            val intent = Intent(this,Game::class.java)
            startActivity(intent)
        }

        restart_game.setOnClickListener {
            val intent = Intent(this,Game::class.java)
            startActivity(intent)
        }


    }
}