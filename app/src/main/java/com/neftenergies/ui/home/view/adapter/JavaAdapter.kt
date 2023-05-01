package com.neftenergies.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neftenergies.databinding.ItemHomeJavaBinding


class JavaAdapter : RecyclerView.Adapter<JavaAdapter.JavaViewHolder>() {

    class JavaViewHolder (itemView: ItemHomeJavaBinding) : RecyclerView.ViewHolder(itemView.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JavaViewHolder {
        return JavaViewHolder(ItemHomeJavaBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: JavaViewHolder, position: Int) {

    }
}