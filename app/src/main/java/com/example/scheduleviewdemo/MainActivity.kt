package com.example.scheduleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        var list = ArrayList<Course>()
        list.add(Course(1,1,1,2,0))
        list.add(Course(2,1,3,4,0))
        list.add(Course(3,1,3,3,1))
        list.add(Course(4,1,2,3,2))
        var adapter = SVAdapter(this,list)
        sv_main.adapter = adapter
        sv_main.post {
            sv_main.show()
        }
    }
}