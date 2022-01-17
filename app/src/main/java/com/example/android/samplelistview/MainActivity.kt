package com.example.android.samplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.samplelistview.databinding.ActivityMainBinding
import com.example.android.samplelistview.network.ApiClient
import com.example.android.samplelistview.network.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.apiService.fetchCharacters("1")

        client.enqueue(object: Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful){
                    val result = response.body()?.result
                    result?.let {
                        val adapter = MyAdapter(it)
                        binding.mainRecyclerview.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"${t.message}", Toast.LENGTH_LONG).show()
            }
        })

    }
}