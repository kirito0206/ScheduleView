package com.example.scheduleviewdemo

import android.content.Context
import android.media.Image
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_schedule.view.*


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
        when (courseList[position].type) {
            //只有单一控件，可以不用另外创建layout
            1 -> {
                val imageView = ImageView(context)
                imageView.setImageResource(R.drawable.image0)
                imageView.foregroundGravity = Gravity.CENTER
                return imageView
            }
            2 -> {
                val editText = EditText(context)
                editText.hint = "输入行程"
                editText.textSize = 16.0f
                editText.gravity = Gravity.CENTER
                return editText
            }
            //对layout进行初始化赋值
            else -> {
                val inflater =
                    LayoutInflater.from(context)
                var view =  inflater.inflate(R.layout.item_schedule, null)
                //view.textview.text = "内容"...
                view.foregroundGravity = Gravity.CENTER
                return  view
            }
        }

    }

    override fun getXTitle(position: Int): String {
        return "第${position}天"
    }

    override fun getYTitle(position: Int): String {
        return "$position"
    }

}