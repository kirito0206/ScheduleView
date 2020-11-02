package com.example.scheduleviewdemo

import android.view.View

abstract class ScheduleAdapter {

    abstract fun getItemCount() : Int

    abstract fun getDay(position: Int) : Int

    abstract fun getBoundary(position : Int) : Pair<Int,Int>

    abstract fun getView(position: Int) : View

    abstract fun getXTitle(position: Int) : String

    abstract fun getYTitle(position: Int) : String
}