package com.example.scheduleviewdemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.GridLayout
import android.widget.TextView

class ScheduleView : GridLayout{

    private var mContext : Context

    constructor(context : Context,attrs : AttributeSet) : super(context,attrs) {
        mContext = context
    }

    var adapter : ScheduleAdapter? = null

    fun show(){
        initTitle()
        if (adapter == null)
            return
        for (i in 0 until adapter!!.getItemCount()){
            var t = adapter!!.getBoundary(i)
            val rowSpec: Spec =
                spec(t.first, t.second - t.first +1)
            val columnSpec = spec(adapter!!.getDay(i), 1)
            val params =
                LayoutParams(rowSpec, columnSpec)
            params.width = (this.width-48)/columnCount
            params.height = (this.height-48)/rowCount * (t.second - t.first +1)
            params.setMargins(5,5,5,5)
            params.setGravity(Gravity.CENTER and Gravity.FILL)
            this.addView(adapter!!.getView(i),params)
        }
    }

    private fun initTitle(){
        for (i in 1 until this.columnCount) {
            val rowSpec = spec(0, 1, 0.0f)
            val columnSpec = spec(i, 1, 1.0f)
            val params =
                LayoutParams(rowSpec, columnSpec)
            val textView = TextView(mContext)
            textView.text = adapter!!.getXTitle(i)
            params.setGravity(Gravity.CENTER_HORIZONTAL)
            this.addView(textView, params)
        }
        for (i in 1 until this.rowCount) {
            val rowSpec = spec(i, 1, 1.0f)
            val columnSpec = spec(0, 1, 0.0f)
            val params =
                LayoutParams(rowSpec, columnSpec)
            val textView = TextView(mContext)
            textView.text = adapter!!.getYTitle(i)
            params.setGravity(Gravity.CENTER_VERTICAL)
            this.addView(textView, params)
        }
    }
}