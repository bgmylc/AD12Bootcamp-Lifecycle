package com.begumyolcu.sayacapp

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber

class SayacTimer(lifecycle: Lifecycle) : LifecycleEventObserver {

    var sayilanSaniye = 0

    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    init {
        lifecycle.addObserver(this)
    }

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

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_START) startTimer()
        else if (event == Lifecycle.Event.ON_STOP) stopTimer()
    }

}