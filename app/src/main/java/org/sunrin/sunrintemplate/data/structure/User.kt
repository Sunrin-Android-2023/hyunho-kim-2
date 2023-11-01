package org.sunrin.sunrintemplate.data.structure

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: String,
    var pw: String,
    var nickname: String,
    var description: String,
    @DrawableRes
    var profileImg: Int
) : Parcelable
