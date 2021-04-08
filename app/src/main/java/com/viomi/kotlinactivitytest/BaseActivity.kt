package com.viomi.kotlinactivitytest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.security.AccessControlContext

open class BaseActivity :AppCompatActivity(){
    private val tag="BaseActivity:tag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag,"$tag:${javaClass.simpleName}")
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {  //销毁
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}