package com.example.android.samplelistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( private val arrayList: ArrayList<User>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount()= arrayList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val profileImage = view.findViewById<ImageView>(R.id.profile_imageView)
        val name = view.findViewById<TextView>(R.id.name_textview)

        fun bind(user:User){
            name.text = user.name
            profileImage.setImageResource(user.imageId)
        }
    }

}