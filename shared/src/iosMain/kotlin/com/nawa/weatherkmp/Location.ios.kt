package com.nawa.weatherkmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.currentLocationOrNull
import dev.jordond.compass.geolocation.mobile

class IosLocatable : Locatable {

    private val geolocator = Geolocator.mobile()

    override suspend fun getLocation(): Location {
        val result = geolocator.currentLocationOrNull()
            ?: throw Exception("Unable to get current location")

        return Location(
            lat = result.coordinates.latitude,
            lang = result.coordinates.longitude
        )
    }
}

@Composable
actual fun rememberLocatable(): Locatable {
    return remember {
        IosLocatable()
    }
}