package com.example.midterm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midterm.R
import com.example.midterm.api.DataInner
import kotlinx.android.synthetic.main.product_detailed.view.*

class ProductDetailedAdapter(private val productInfo: List<DataInner>): RecyclerView.Adapter<ProductDetailedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailedAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_detailed, parent, false))
    }

    override fun onBindViewHolder(holder: ProductDetailedAdapter.ViewHolder, i: Int) {
        holder.name.text = productInfo[i].name.toString()
        holder.price.text = productInfo[i].price
        holder.description.text = productInfo[i].description
        holder.discount_amount.text = productInfo[i].discount_amount
        holder.status.text = productInfo[i].status.toString()
        Glide.with(holder.itemView.context).load(productInfo[i].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productInfo.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.innerName
        val description = itemView.innerDescription
        val price = itemView.innerPrice
        val discount_amount = itemView.innerDiscountAmount
        val image = itemView.innerImage
        val status = itemView.innerStatus
    }

}
