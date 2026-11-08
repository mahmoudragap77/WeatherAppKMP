package com.nawa.weatherkmp

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.currentLocationOrNull
import dev.jordond.compass.geolocation.mobile

class AndroidLocatable: Locatable {

    val geoLocator  = Geolocator.mobile()
    @SuppressLint("MissingPermission")
    override suspend fun getLocation(): Location {

        val locator = geoLocator.currentLocationOrNull()
            ?: throw Exception("Unable to get current location")

        return Location(lat = locator.coordinates.latitude, lang = locator.coordinates.longitude)

    }
}

@Composable
actual fun rememberLocatable(): Locatable {
    val context = LocalContext.current
    return remember(context) { AndroidLocatable() }
}