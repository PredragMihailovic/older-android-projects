package com.example.johnny.placeguess.pojos

import com.google.android.gms.maps.model.LatLng

interface Location {
    var name: String
    var country: String
    var coordinates: LatLng
    var imageUrl: String
}
