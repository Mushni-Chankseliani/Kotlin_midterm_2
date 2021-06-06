package com.example.midterm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midterm.R
import com.example.midterm.activity.Detailed
import com.example.midterm.api.Data
import kotlinx.android.synthetic.main.products.view.*

class ProductsListAdapter(private val data: List<Data>): RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.products, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsListAdapter.ViewHolder, i: Int) {
        holder.name.text = data[i].name.toString()
        holder.price.text = data[i].price
        holder.discountAmount.text = data[i].discount_amount
        holder.status.text = data[i].status.toString()
        Glide.with(holder.itemView.context).load(data[i].image).into(holder.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, Detailed::class.java)
            intent.putExtra("id", data[i].id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.name!!
        val price = itemView.price!!
        val discountAmount = itemView.discount_amount!!
        val image= itemView.imageView!!
        val status = itemView.status!!
    }

}
