package com.example.bartoszczajkowski.politechnikayoutubeapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*




class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = CourseDetailAdapter()
    }

    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>() {

        override fun getItemCount(): Int {
            return 2
        }

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CourseLessonViewHolder {

            val layoutInflater = LayoutInflater.from(parent?.context)
            val customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)

            return CourseLessonViewHolder(customView)
        }

        override fun onBindViewHolder(p0: CourseLessonViewHolder, p1: Int) {

        }

    }
    
    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView) {

    }

}
