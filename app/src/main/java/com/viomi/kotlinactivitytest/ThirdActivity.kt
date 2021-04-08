package com.viomi.kotlinactivitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.viomi.kotlinactivitytest.databinding.FirstLayoutBinding
import com.viomi.kotlinactivitytest.databinding.ThirdLayoutBinding

class ThirdActivity : BaseActivity() {
    val TAG="ThirdActivity_TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ThirdLayoutBinding.inflate(layoutInflater)    //FirstLayoutBinding 是根据布局文件自动生成
        Log.d(TAG,"taskid:$taskId")
        setContentView(binding.root)
        binding.btn3.text="phone"
        binding.btn3.setOnClickListener {   // 调用拨号界面
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data= Uri.parse("tel:122")
            startActivity(intent)
        }
        binding.btnChangeTest.setText("test put data")
        binding.btnChangeTest.setOnClickListener {
            val data1=intent.getStringExtra("data1")
            Log.i(TAG,"data1 is $data1")
            val data2=intent.getIntExtra("data2",0)
            Log.i(TAG,"data2 is $data2")
            val data3=intent.getBooleanExtra("data3",true)
            Log.i(TAG,"data3 is $data3")
        }
    }
}