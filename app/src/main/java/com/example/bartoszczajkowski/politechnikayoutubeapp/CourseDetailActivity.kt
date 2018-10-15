package com.example.bartoszczajkowski.politechnikayoutubeapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = CourseDetailAdapter()

        val navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle

        fetchJson()
    }

    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>() {

        override fun getItemCount(): Int {
            return 5
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


    fun fetchJson() {

        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)
        val courseDetailURL = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId

//        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
//        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        val request = Request.Builder().url(courseDetailURL).build()


        client.newCall(request).enqueue(object: Callback {


            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val courseLessons = gson.fromJson(body, Array<CourseLesson>::class.java)

                //val homeFeed = gson.fromJson(body, HomeFeed::class.java)

//                runOnUiThread {
//                    recyclerView_main.adapter = MainAdapter(homeFeed)
//                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }

}
