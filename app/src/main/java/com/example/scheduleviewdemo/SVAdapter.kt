package com.example.scheduleviewdemo

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView

class SVAdapter(val context : Context,val courseList: ArrayList<Course>) : ScheduleAdapter() {

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun getDay(position: Int): Int {
        return courseList[position].week
    }

    override fun getBoundary(position: Int): Pair<Int, Int> {
        return Pair(courseList[position].timeX, courseList[position].timeY)
    }

    override fun getView(position: Int): View {
        val textView = TextView(context)
        textView.text = position.toString()
        textView.gravity = Gravity.CENTER
        return textView
    }

    override fun getXTitle(position: Int): String {
        return "第一周"
    }

    override fun getYTitle(position: Int): String {
        return "$position"
    }

}