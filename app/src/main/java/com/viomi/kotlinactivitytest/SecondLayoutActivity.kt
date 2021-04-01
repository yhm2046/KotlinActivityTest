package com.viomi.kotlinactivitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
    }
}