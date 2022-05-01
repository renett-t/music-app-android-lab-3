package ru.itis.musicapp.presentation

import android.os.Bundle
import moxy.MvpAppCompatActivity
import ru.itis.musicapp.R

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
