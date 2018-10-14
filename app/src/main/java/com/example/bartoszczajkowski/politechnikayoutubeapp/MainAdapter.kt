package com.example.bartoszczajkowski.politechnikayoutubeapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, p0, false)
        return CustomViewHolder(cellForRow)
    }


    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
//        val videoTitle = videoTitles.get(position)
//        holder?.view?.textView_video_title?.text = videoTitle
    }


}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}