package com.neftenergies.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neftenergies.databinding.ItemHomeSecurityBinding

class SecurityAdapter :RecyclerView.Adapter<SecurityAdapter.SecurityViewHolder>() {
    class SecurityViewHolder (itemView: ItemHomeSecurityBinding) : RecyclerView.ViewHolder(itemView.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecurityViewHolder {
        return SecurityAdapter.SecurityViewHolder(ItemHomeSecurityBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
       return 5
    }

    override fun onBindViewHolder(holder: SecurityViewHolder, position: Int) {

    }
}