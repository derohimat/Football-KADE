package net.derohimat.ktanddevexp.model

import android.os.Parcel
import android.os.Parcelable

data class Item(val name: String?, val image: Int?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}