package com.begumyolcu.sayacapp

import android.os.Handler
import android.os.Looper
import timber.log.Timber

class SayacTimer() {
    var sayilanSaniye = 0

    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    fun startTimer() {
        runnable = Runnable {
            sayilanSaniye++
            Timber.i("Timer saniyesi : $sayilanSaniye")
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }

    fun stopTimer() {
        handler.removeCallbacks(runnable)
    }

}