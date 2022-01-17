package com.example.android.samplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.samplelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.ic_baseline_airline_seat_flat_24,
            R.drawable.ic_baseline_airline_seat_recline_extra_24,
            R.drawable.ic_baseline_airline_seat_recline_normal_24,
            R.drawable.ic_baseline_accessibility_24,
            R.drawable.ic_baseline_airline_seat_flat_24,
            R.drawable.ic_baseline_airline_seat_recline_extra_24,
            R.drawable.ic_baseline_airline_seat_recline_normal_24,
            R.drawable.ic_baseline_accessibility_24,
            R.drawable.ic_baseline_airline_seat_flat_24,
            R.drawable.ic_baseline_airline_seat_recline_extra_24,
            R.drawable.ic_baseline_airline_seat_recline_normal_24,
            R.drawable.ic_baseline_accessibility_24
        )

        val name = arrayOf(
            "Ram",
            "Shyam",
            "Ghanshyam",
            "Alex",
            "Ram",
            "Shyam",
            "Ghanshyam",
            "Alex",
            "Ram",
            "Shyam",
            "Ghanshyam",
            "Alex"
        )
        val country = arrayOf(
            "India",
            "Nepal",
            "Pakistan",
            "China",
            "India",
            "Nepal",
            "Pakistan",
            "China",
            "India",
            "Nepal",
            "Pakistan",
            "China"
        )

        //Initializing userArrayList
        userArrayList = ArrayList()

        //Assigning values to userArrayList
        for(i in name.indices){
            val user = User(name[i], country[i], imageId[i])
            userArrayList.add(user)
        }
        binding.listView.adapter = MyAdapter(this, userArrayList)
    }
}