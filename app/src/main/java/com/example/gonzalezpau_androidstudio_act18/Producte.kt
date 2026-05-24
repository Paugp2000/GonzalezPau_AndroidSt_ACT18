package com.example.gonzalezpau_androidstudio_act18

import android.os.Parcel
import android.os.Parcelable


data class Producte(
    val nom: String?,
    val preu: Double,
    val imatgeId: Int,
    var quantitat: Int = 0
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeDouble(preu)
        parcel.writeInt(imatgeId)
        parcel.writeInt(quantitat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producte> {
        override fun createFromParcel(parcel: Parcel): Producte {
            return Producte(parcel)
        }

        override fun newArray(size: Int): Array<Producte?> {
            return arrayOfNulls(size)
        }
    }
}