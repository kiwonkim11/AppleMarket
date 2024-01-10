package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem(
    val aIcon: Int,
    val aName: String,
    val aPost: String,
    val aNickname: String,
    val aAddress: String,
    val aPrice: Int,
    val aChat: Int,
    val aGood: Int
) : Parcelable