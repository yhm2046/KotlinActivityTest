package com.viomi.kotlinactivitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.viomi.kotlinactivitytest.databinding.FirstLayoutBinding

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity tag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FirstLayoutBinding.inflate(layoutInflater)    //FirstLayoutBinding 是根据布局文件自动生成
        Log.d(TAG,"first activity task id:$taskId")
        setContentView(binding.root)
        binding.btn351.setOnClickListener {//测试standard模式
              val intent=Intent(this,SecondLayoutActivity::class.java)
            startActivity(intent)
        }
        binding.btn335.setOnClickListener {
            val intent=Intent(this,SecondLayoutActivity::class.java)
            startActivityForResult(intent,1)
            Log.i(TAG,"click...")
        }
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

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"first onDestory..")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"first onRestart..")
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if (resultCode== Activity.RESULT_OK){
                val returnedData=data?.getStringExtra("data_return")
                Log.i(TAG,"returnedData:$returnedData")
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.add_item -> {
                Toast.makeText(this, "adding..", Toast.LENGTH_LONG).show()
                val intent = Intent(Intent.ACTION_VIEW) //调用系统浏览器打开网页
                intent.data = Uri.parse("https://www.google.com/ncr")
                startActivity(intent)
            }
            R.id.remove_item -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                val data="make money"
                val data2=99
                val data3=false
                val intent = Intent(this,ThirdActivity::class.java)
                intent.putExtra("data1",data)
                intent.putExtra("data2",data2)
                intent.putExtra("data3",data3)
                startActivity(intent)
            }
        }
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }
}