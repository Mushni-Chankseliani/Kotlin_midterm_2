package com.example.midterm.api

data class DataInner(
    val categories: List<CategoryInner>,
    val description: String,
    val discount_amount: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: String,
    val status: Boolean
)
