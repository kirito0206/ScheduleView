package com.example.scheduleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<Course>()
        list.add(Course(1,1,1,2))
        list.add(Course(2,1,2,3))
        list.add(Course(3,1,3,4))
        var adapter = SVAdapter(this,list)
        sv_main.adapter = adapter
        sv_main.show()
    }
}