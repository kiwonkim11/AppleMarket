package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter (private val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    interface ItemLongClick {
        fun onLongClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener{
            itemLongClick?.onLongClick(it, position)
            return@setOnLongClickListener true
        }

        val dec = DecimalFormat("#,###")

        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.name.text = mItems[position].aName
        holder.address.text = mItems[position].aAddress
        holder.price.text = "${dec.format(mItems[position].aPrice)}원"
        holder.chat.text = "${mItems[position].aChat}"
        holder.good.text = "${mItems[position].aGood}"

        if(mItems[position].isGood){
            holder.ivGood.setImageResource(R.drawable.red_heart)
        } else {
            holder.ivGood.setImageResource(R.drawable.heart)
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name = binding.textItemName
        val address = binding.textItemAddress
        val price = binding.textItemPrice
        val chat = binding.textItemChat
        val good = binding.textItemGood
        val ivGood = binding.ivGood
    }
}