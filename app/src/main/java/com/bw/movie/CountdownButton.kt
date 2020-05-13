package com.bw.movie

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.Button

class CountdownButton(mContext: Context, attrSet: AttributeSet) : Button(mContext, attrSet) {
    private val mHandler: Handler = Handler();
    private var mCountTime = 5


    init {
        this.text = "跳转5S"
    }

    fun sendVerifyCode() {
        mHandler.postDelayed(countDown, 0)
    }

    private val countDown = object : Runnable {
        override fun run() {
            this@CountdownButton.text = mCountTime.toString() + "s "
            this@CountdownButton.isEnabled = false

            if (mCountTime > 0) {
                mHandler.postDelayed(this, 1000)
            } else {
                resetCounter()
            }
            mCountTime--
        }
    }

    fun removeRunable() {
        mHandler.removeCallbacks(countDown)
    }

    //重置按钮状态
    fun resetCounter(vararg text: String) {
        this.isEnabled = true
        if (text.isNotEmpty() && "" != text[0]) {
            this.text = text[0]
        } else {
            this.text = "跳转5S"
        }
        mCountTime = 30
    }
}
