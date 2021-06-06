package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm.adapter.ProductsListAdapter
import com.example.midterm.api.Api
import com.example.midterm.api.DataList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL = "https://gorest.co.in/public-api/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyProduct()
    }

    private fun getMyProduct() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL).build().create(Api::class.java)

        val productsList = retrofitBuilder.getProductsList()

        productsList.enqueue(object : Callback<DataList> {

            override fun onResponse(call: Call<DataList>?, response: Response<DataList>?) {

                val responseData = response!!.body().data
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = responseData?.let { ProductsListAdapter(it) }
                count.text = responseData!!.size.toString()

            }

            override fun onFailure(call: Call<DataList>?, t: Throwable?) { }

        })
    }

}
