package com.neftenergies.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neftenergies.databinding.ItemHomeFeaturedCoursesBinding

class CourseListAdapter :RecyclerView.Adapter<CourseListAdapter.CourseListViewHolder> (){

    class CourseListViewHolder  (itemView: ItemHomeFeaturedCoursesBinding) : RecyclerView.ViewHolder(itemView.root)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseListViewHolder {
        return CourseListViewHolder(ItemHomeFeaturedCoursesBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun getItemCount(): Int {
       return 5
    }

    override fun onBindViewHolder(holder: CourseListViewHolder, position: Int) {

    }
}