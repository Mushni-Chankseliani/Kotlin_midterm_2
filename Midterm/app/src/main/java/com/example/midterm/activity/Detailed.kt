package com.example.midterm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm.R
import com.example.midterm.URL
import com.example.midterm.adapter.ProductDetailedAdapter
import com.example.midterm.api.Api
import com.example.midterm.api.ProductDetailed
import kotlinx.android.synthetic.main.activity_detailed.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Detailed : AppCompatActivity() {
    private var id = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        id = intent.getStringExtra("id").toString()
        getProductDetailed()
    }

    private fun getProductDetailed() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL).build().create(Api::class.java)

        val productDetailed = retrofitBuilder.getProductDetailed(id)

        productDetailed.enqueue(object : Callback<ProductDetailed> {

            override fun onResponse(call: Call<ProductDetailed>?, response: Response<ProductDetailed>?) {

                val responseData = response!!.body().data
                recyclerDetailed.layoutManager = LinearLayoutManager(this@Detailed)

                recyclerDetailed.adapter = responseData?.let { ProductDetailedAdapter(listOf(it)) }
            }

            override fun onFailure(call: Call<ProductDetailed>?, t: Throwable?) { }

        })
    }

}
