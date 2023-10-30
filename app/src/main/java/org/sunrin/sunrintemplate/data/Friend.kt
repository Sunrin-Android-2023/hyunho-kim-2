package org.sunrin.sunrintemplate.data

import androidx.annotation.DrawableRes

data class Friend(
    @DrawableRes
    var profileImg: Int,
    var nickname: String,
    var description: String
)