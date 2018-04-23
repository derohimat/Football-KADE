package net.derohimat.ktanddevexp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val name: String?, val image: Int?) : Parcelable