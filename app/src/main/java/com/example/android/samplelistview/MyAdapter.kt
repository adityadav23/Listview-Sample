package com.example.android.samplelistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>):
    ArrayAdapter<User>(context,R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

    val view: View  = LayoutInflater.from(context).inflate(R.layout.list_item, null)

        val profileImageView = view.findViewById<ImageView>(R.id.profile_imageView)
        val nameTextView = view.findViewById<TextView>(R.id.name_textview)
        val countryTextView = view.findViewById<TextView>(R.id.country_textview)

        profileImageView.setImageResource(arrayList[position].imageId)
        nameTextView.text = arrayList[position].name
        countryTextView.text = arrayList[position].country
        return view
    }
}