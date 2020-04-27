package com.example.johnny.placeguess.pojos

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.parcel.Parcelize

@Parcelize
class Street(override var name: String,
             override var country: String,
             override var coordinates: LatLng,
             override var imageUrl: String) : Location, Parcelable {
}