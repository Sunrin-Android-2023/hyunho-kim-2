package org.sunrin.sunrintemplate.data

import androidx.annotation.DrawableRes

data class Friend(
    @DrawableRes
    val profileImg: Int,
    val nickname: String,
    val description: String
)