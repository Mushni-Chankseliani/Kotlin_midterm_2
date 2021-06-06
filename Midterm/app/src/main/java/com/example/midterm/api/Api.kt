package com.example.midterm.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("products")
    fun getProductsList(): Call<DataList>
    @GET("products/{id}")
    fun getProductDetailed(@Path("id") id: String): Call<ProductDetailed>
}
