package com.nawa.weatherkmp

import androidx.compose.runtime.Composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


interface Locatable {

    suspend fun getLocation() : Location
}

@Serializable
data class Location(
    @SerialName(Constant.LAT)
    val lat:Double,
    @SerialName(Constant.LON)
    val lang :Double
)
@Composable
expect fun rememberLocatable() :Locatable