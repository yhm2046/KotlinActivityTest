package com.viomi.kotlinactivitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.viomi.kotlinactivitytest.databinding.FirstLayoutBinding
import com.viomi.kotlinactivitytest.databinding.ThirdLayoutBinding

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ThirdLayoutBinding.inflate(layoutInflater)    //FirstLayoutBinding 是根据布局文件自动生成
        setContentView(binding.root)
        binding.btn3.text="phone"
        binding.btn3.setOnClickListener {   // 调用拨号界面
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data= Uri.parse("tel:122")
            startActivity(intent)
        }
    }
}