package com.example.applemarket

import android.graphics.Paint
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
        binding.txtdetailNickname.text = dataList.aNickname
        binding.txtdetailAddress.text = dataList.aAddress
        binding.txtdetailPost.text = dataList.aPost

        binding.txtManner.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        binding.ivBack.setOnClickListener {
            finish()
        }

    }
}