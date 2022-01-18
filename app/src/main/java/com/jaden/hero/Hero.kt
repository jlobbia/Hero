package com.jaden.hero

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var name: String,
    var description: String,
    var superpower: String,
    var ranking: Int,
    var image: String,
):Parcelable