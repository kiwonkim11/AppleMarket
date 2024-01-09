package com.example.applemarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applemarket.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = intent.getParcelableExtra<MyItem>("selectedItem")

        binding.ivItem.setImageResource(dataList!!.aIcon)
        binding.txtdetailName.text = dataList.aName
        binding.txtdetailAddress.text = dataList.aAddress


        binding.ivBack.setOnClickListener {
            finish()
        }

    }
}