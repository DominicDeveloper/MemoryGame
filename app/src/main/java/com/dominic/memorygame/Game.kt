package com.dominic.memorygame

import android.annotation.SuppressLint
import android.app.Notification
import android.content.Intent
import android.icu.text.AlphabeticIndex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.security.cert.Extension

class Game : AppCompatActivity() {
    var minute = 0
    var secund = 60
    var record = 0
    val check_anim = arrayOf(false,false,false,false,false,false,false,false,false,false,false,false,false)
    val imageIndex = arrayOfNulls<Int>(2)
    val IdRasm = arrayOfNulls<Int>(2)
    var checkOpenCards = 0
    var nothing = 0
    var animationdoing = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        img_1.setOnClickListener {
                cardClick(img_1,R.drawable.tank,0)
        }
        img_2.setOnClickListener {
                cardClick(img_2,R.drawable.vehicle,1)
        }
        img_3.setOnClickListener {
                cardClick(img_3,R.drawable.ak,2)
        }
        img_4.setOnClickListener {
                cardClick(img_4,R.drawable.knife,3)
        }
        img_5.setOnClickListener {
                cardClick(img_5,R.drawable.hacking,4)
        }
        img_6.setOnClickListener {
           cardClick(img_6,R.drawable.knife,5)
        }
        img_7.setOnClickListener {
                cardClick(img_7,R.drawable.vehicle,6)
        }
        img_8.setOnClickListener {
                cardClick(img_8,R.drawable.pc,7)
        }
        img_9.setOnClickListener {

                cardClick(img_9,R.drawable.ak,8)
        }
        img_10.setOnClickListener {

                cardClick(img_10,R.drawable.pc,9)
        }
        img_11.setOnClickListener {

                cardClick(img_11,R.drawable.tank,10)

        }
        img_12.setOnClickListener {

                cardClick(img_12,R.drawable.hacking,11)
        }


        Time().start()





    }
    fun cardClick(imageView: ImageView,rasm: Int, index:Int) {
        if (!animationdoing){

            if (check_anim[index] == false)
            {
                openinig(imageView,rasm,index)
            }else{

                closing(imageView,rasm,index)
            }
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)

        when(item.itemId)
        {
           R.id.nightmode -> {
             background_game.setBackgroundColor(R.drawable.register_fon_6)
           }
            R.id.lightmode ->{
                background_game.setBackgroundColor(R.drawable.register_fon_4)
            }

        }
    }
    fun openinig(imageView: ImageView,rasm : Int,index: Int) {
        val animation = AnimationUtils.loadAnimation(this,R.anim.scale)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {

                val anim_2 = AnimationUtils.loadAnimation(this@Game,R.anim.anim_1)

                imageView.startAnimation(anim_2)
                imageView.setImageResource(rasm)
                anim_2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                        animationdoing = true

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        check_anim[index] = true
                        imageIndex[checkOpenCards] = index
                        IdRasm[checkOpenCards] = rasm
                        checkOpenCards++

                        if (checkOpenCards == 2)
                        {
                            if (IdRasm[0] == IdRasm[1])
                            {
                                record++
                                correctanswer(findImg(imageIndex[0]),findImg(imageIndex[1]))

                            }else{
                                closing(findImg(imageIndex[0]),-1,imageIndex[0])
                                closing(findImg(imageIndex[1]),-1,imageIndex[1])
                            }

                        }

                        animationdoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }
                })


            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })


    }
    fun closing(imageView: ImageView,rasm : Int,index: Int?) {
        val animation = AnimationUtils.loadAnimation(this,R.anim.scale)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

                animationdoing = true


            }

            override fun onAnimationEnd(animation: Animation?) {

                val anim_2 = AnimationUtils.loadAnimation(this@Game,R.anim.anim_1)

                imageView.startAnimation(anim_2)
                imageView.setImageResource(R.drawable.gamefon)
                anim_2.setAnimationListener(object  : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {

                        animationdoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }
                })


            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        check_anim[index!!] = false
        checkOpenCards--

    }
    fun findImg(index: Int?,):ImageView {
        var imageView:ImageView? = null

        when(index){

            0 -> imageView = img_1
            1 -> imageView = img_2
            2 -> imageView = img_3
            3 -> imageView = img_4
            4 -> imageView = img_5
            5 -> imageView = img_6
            6 -> imageView = img_7
            7 -> imageView = img_8
            8 -> imageView = img_9
            9 -> imageView = img_10
            10 -> imageView = img_11
            11 -> imageView = img_12


        }
        return imageView!!
    }
    fun minute() {

        if(secund == 0 && minute != 0)
        {
            minute--
            secund = 60
        }


    }
    fun correctanswer(imageView_1: ImageView,imageView_2: ImageView) {
        val animremoving = AnimationUtils.loadAnimation(this,R.anim.absenting_anim)

        imageView_1.startAnimation(animremoving)
        imageView_2.startAnimation(animremoving)

        animremoving.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

                animationdoing = true

            }

            override fun onAnimationEnd(animation: Animation?) {

                findImg(imageIndex[0]).visibility = View.INVISIBLE
                checkOpenCards--
                findImg(imageIndex[1]).visibility = View.INVISIBLE
                checkOpenCards--
                animationdoing = false
                toWin()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

    }
    fun stoptime()
    {

        img_1.isEnabled = false
        img_2.isEnabled = false
        img_3.isEnabled = false
        img_4.isEnabled = false
        img_5.isEnabled = false
        img_6.isEnabled = false
        img_7.isEnabled = false
        img_8.isEnabled = false
        img_9.isEnabled = false
        img_10.isEnabled = false
        img_11.isEnabled = false
        img_12.isEnabled = false
        val i = Intent(this,MyRecord::class.java)
        val record = Record(record.toString())
        i.putExtra("rc",record)
        startActivity(i)
    }
    fun win_game()
    {
        val i = Intent(this,MyRecord::class.java)
        val record = Record(record.toString())
        i.putExtra("rc",record)
        startActivity(i)
    }
    fun toWin()
    {
        if (record == 6)
        {
            win_game()
        }else{
               nothing += 1
        }
    }

    @SuppressLint("SetTextI18n")
    fun take_error() {

        if (minute == 0 && secund == 0)
        {
            try {
                time_text.text = "Time End"
                time_text.setTextColor(ContextCompat.getColor(applicationContext,R.color.red))
                stoptime()


            }catch (e:Exception)
            {
                Toast.makeText(this, "Time end!", Toast.LENGTH_SHORT).show()
            }



        }


    }
    inner class Time:Thread() {
        override fun run() {
            super.run()


            while (minute != 0 || secund != 0 )
            {
                    secund--
                    minute()
                    time_text.text = "$minute:$secund"
                    sleep(1000)

            }
            take_error()

        }


    }

}
