package com.neftenergies.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neftenergies.databinding.ItemHomeFeaturedCoursesBinding

class CourseAdapter :RecyclerView.Adapter<CourseAdapter.CourseViewHolder>(){

    class CourseViewHolder (itemView: ItemHomeFeaturedCoursesBinding) : RecyclerView.ViewHolder(itemView.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(ItemHomeFeaturedCoursesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {

    }
}