package com.example.android.samplelistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.samplelistview.network.Character
import com.squareup.picasso.Picasso

class MyAdapter( private val arrayList: List<Character>):
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

        fun bind(character: Character){
            name.text = character.name

            Picasso.get().load(character.image).into(profileImage)        }
    }

}