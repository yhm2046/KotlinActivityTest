package com.viomi.kotlinactivitytest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.viomi.kotlinactivitytest.databinding.FirstLayoutBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FirstLayoutBinding.inflate(layoutInflater)    //FirstLayoutBinding 是根据布局文件自动生成
        setContentView(binding.root)
        binding.btn1.text="auto change"
        binding.btn20.setOnClickListener {
            val intent=Intent("com.viomi.kotlinactivitytest.ACTION_START")  //隐式intent
            intent.addCategory("com.viomi.kotlinactivitytest.MY_CATEGORY")
            startActivity(intent)
        }
        binding.btn1.setOnClickListener {
            Toast.makeText(this,"open second activity",Toast.LENGTH_LONG).show()
            val intent=Intent(this,SecondLayoutActivity::class.java)    //显示intent
            startActivity(intent)
//            finish()
        }

    }//end onCreate

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.add_item -> {
                Toast.makeText(this, "adding..", Toast.LENGTH_LONG).show()
                val intent = Intent(Intent.ACTION_VIEW) //调用系统浏览器打开网页
                intent.data = Uri.parse("https://www.google.com/ncr")
                startActivity(intent)
            }
            R.id.remove_item -> Toast.makeText(this, "removing..", Toast.LENGTH_LONG).show()
        }
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }
}