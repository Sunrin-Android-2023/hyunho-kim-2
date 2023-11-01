package org.sunrin.sunrintemplate.data.structure

import androidx.annotation.DrawableRes

data class Friend(
    @DrawableRes
    var profileImg: Int,
    var nickname: String,
    var description: String
)