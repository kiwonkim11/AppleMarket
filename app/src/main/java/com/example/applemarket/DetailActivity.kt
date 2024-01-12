package com.example.applemarket

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applemarket.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var isGood = false
    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = intent.getParcelableExtra<MyItem>(Constants.ITEM_OBJECT)

        val dec = DecimalFormat("#,###")

        binding.ivItem.setImageResource(dataList!!.aIcon)
        binding.txtdetailName.text = dataList.aName
        binding.txtdetailNickname.text = dataList.aNickname
        binding.txtdetailPrice.text = "${dec.format(dataList.aPrice)}원"
        binding.txtdetailAddress.text = dataList.aAddress
        binding.txtdetailPost.text = dataList.aPost

        binding.txtManner.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        isGood = dataList?.isGood == true
        binding.ivIsgood.setImageResource(if(isGood) {R.drawable.red_heart} else {R.drawable.heart})

        binding.ivIsgood.setOnClickListener {
            if(!isGood) {
                binding.ivIsgood.setImageResource(R.drawable.red_heart)
                Snackbar.make(binding.constraintMain, "관심 목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                isGood = true
            } else {
                binding.ivIsgood.setImageResource(R.drawable.heart)
                isGood = false
            }
        }

        binding.ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra("goodIndex", itemPosition)
                putExtra("isGood", isGood)
            }

            setResult(RESULT_OK, intent)
            if(!isFinishing) finish()
        }

    }
}