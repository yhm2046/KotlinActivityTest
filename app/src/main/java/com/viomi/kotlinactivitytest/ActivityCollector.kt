package com.viomi.kotlinactivitytest

import android.app.Activity
import android.util.Log

/**
 * Activity集合
 */
object ActivityCollector {
    private val tag="ActivityCollector tag"
    private val activities=ArrayList<Activity>()
    fun addActivity(activity: Activity){
        activities.add(activity)
        Log.d(tag,"addActivity")
    }
    fun removeActivity(activity: Activity){
        activities.remove(activity)
        Log.d(tag,"removeActivity")
    }
    fun finishAll(){
        for (activity in activities){
            if (!activity.isFinishing) activity.finish()
        }
        Log.d(tag,"finishAll")
        activities.clear()
    }//end finishAll
}