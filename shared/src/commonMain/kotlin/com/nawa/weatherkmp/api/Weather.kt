package com.nawa.weatherkmp.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Weather{
    val current =Current()
}

@Serializable
class Current {
@SerialName("temp_c")
val temperature:Double = 0.0
}
