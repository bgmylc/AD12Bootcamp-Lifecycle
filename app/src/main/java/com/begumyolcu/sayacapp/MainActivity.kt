package com.begumyolcu.sayacapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.begumyolcu.sayacapp.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate Çağrıldı")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val varsayılanDeger = 0

        binding.apply {
            textViewSayac.text = varsayılanDeger.toString()

            buttonSayac.setOnClickListener {
                val gelenDeger = textViewSayac.text.toString().toInt()
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


}