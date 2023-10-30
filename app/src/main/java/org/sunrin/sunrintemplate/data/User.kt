package org.sunrin.sunrintemplate.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String,
    val pw: String,
    val nickname: String
) : Parcelable
