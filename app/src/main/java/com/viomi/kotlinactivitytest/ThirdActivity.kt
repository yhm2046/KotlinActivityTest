package com.viomi.kotlinactivitytest

import android.content.Context
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
        binding.btn3.text="test"
        binding.btn3.setOnClickListener {   // 调用拨号界面
            val intent = Intent(Intent.ACTION_DIAL)
            Log.d(TAG,"param1------>${intent.getStringExtra("param1")},param2------>${intent.getStringExtra("param2")}")
            intent.data= Uri.parse("tel:122")
            startActivity(intent)
        }

        binding.btnChangeTest.setText("exit")
        binding.btnChangeTest.setOnClickListener {
//            退出
             ActivityCollector.finishAll()
            Log.d(TAG,"kill pid------------>${android.os.Process.myPid()}")
            android.os.Process.killProcess(android.os.Process.myPid())
//            val data1=intent.getStringExtra("data1")
//            Log.i(TAG,"data1 is $data1")
//            val data2=intent.getIntExtra("data2",0)
//            Log.i(TAG,"data2 is $data2")
//            val data3=intent.getBooleanExtra("data3",true)
//            Log.i(TAG,"data3 is $data3")
        }//end onClickListener
    }//end onCreate
    companion object{   //启动activity的最佳传递参数写法
        fun actionStart(context: Context, data1:String, data2:String){
            Log.d("3333333333","data1:$data1,data2:$data2")
//            val intent=Intent(context,SecondLayoutActivity::class.java)
//            intent.putExtra("param1",data1)
//            intent.putExtra("param2",data2)
            val intent=Intent(context,ThirdActivity::class.java).apply {//使用标准函数apply精简
                putExtra("param1",data1)
                putExtra("param2",data2)
            }
            context.startActivity(intent)
        }
    }//end object
}