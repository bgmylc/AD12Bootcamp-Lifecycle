package com.begumyolcu.sayacapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.begumyolcu.sayacapp.databinding.ActivityMainBinding
import timber.log.Timber

const val KEY_SANIYE = "timer_saniye_key"
const val KEY_SAYI = "sayi_key"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sayacTimer: SayacTimer
    private var sayi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate Çağrıldı")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sayacTimer = SayacTimer(this.lifecycle)

        binding.apply {
            textViewSayac.text = sayi.toString()

            if (savedInstanceState != null){
                sayi = savedInstanceState.getInt(KEY_SAYI, 0)
                Timber.i(sayi.toString())
                textViewSayac.text = sayi.toString()
                sayacTimer.sayilanSaniye = savedInstanceState.getInt(KEY_SANIYE, 0)
            }


            buttonSayac.setOnClickListener {
                val gelenDeger = textViewSayac.text.toString().toInt()
                sayi = gelenDeger + 1
                textViewSayac.text = (gelenDeger+1).toString()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Çağrıldı")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Çağrıldı")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Çağrıldı")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Çağrıldı")
    }

    override fun onStop() {
        super.onStop()

        Timber.i("onStop Çağrıldı")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Çağrıldı")
    }

    private fun onPaylas(){
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, binding.textViewSayac.text.toString())
        }, null)

        startActivity(share)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.paylas_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_paylas -> onPaylas()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SANIYE, sayacTimer.sayilanSaniye)
        outState.putInt(KEY_SAYI, sayi)
        Timber.i("onSaveInstanceState çağrıldı")
    }

}