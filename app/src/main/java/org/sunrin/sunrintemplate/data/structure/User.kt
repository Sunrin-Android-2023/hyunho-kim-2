package org.sunrin.sunrintemplate.data.structure

import androidx.annotation.DrawableRes

data class User(
    var id: String,
    var pw: String,
    var nickname: String,
    var description: String,
    @DrawableRes
    var profileImg: Int
) {
    data class follow(
        var following: Int,
        var follower: Int
    )
}
