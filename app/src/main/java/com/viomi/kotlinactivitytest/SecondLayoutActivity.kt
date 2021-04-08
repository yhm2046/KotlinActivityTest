package com.viomi.kotlinactivitytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.viomi.kotlinactivitytest.databinding.SecondLayoutBinding

class SecondLayoutActivity : BaseActivity() {
    private val tag="SecondLayoutActivity:tag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.second_layout)
        val binding =SecondLayoutBinding.inflate(layoutInflater)
        Log.d(tag,"oncreate taskid:$taskId")
        setContentView(binding.root)
        binding.btn2.setOnClickListener {
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
//            intent.putExtra("data_return","hello firstactiviy")
//            setResult(RESULT_OK,intent)
//            finish()
        }
    }// end onCreate
    companion object{   //启动activity的最佳传递参数写法
        fun actionStart(context: Context, data1:String, data2:String){
            Log.d("tag:companion","data1:$data1,data2:$data2")
            val intent=Intent(context,SecondLayoutActivity::class.java)
            intent.putExtra("param1",data1)
            intent.putExtra("param2",data2)
            context.startActivity(intent)
        }
    }//end object
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return","back first activity")
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}