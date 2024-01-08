package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter (val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it, position)
        }
        val dec = DecimalFormat("#,###")

        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.name.text = mItems[position].aName
        holder.address.text = mItems[position].aAddress
        holder.price.text = "${dec.format(mItems[position].aPrice).toString()}원"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name = binding.textItemName
        val address = binding.textItemAddress
        val price = binding.textItemPrice
    }
}