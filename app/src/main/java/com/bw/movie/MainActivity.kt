package com.bw.movie

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.bw.movie.R2.id.image
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //点击事件
        val countdownButton = findViewById(R.id.tv_cinema) as CountdownButton;
        countdownButton!!.setOnClickListener {
            countdownButton!!.sendVerifyCode()
        }


        bt_login.setOnClickListener{
            val intent = Intent()
            //获取intent对象
            intent.setClass(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}