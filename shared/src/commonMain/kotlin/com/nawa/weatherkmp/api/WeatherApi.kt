package com.nawa.weatherkmp.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


suspend fun getWeather(lat: Double, long: Double): Double {
    val client = HttpClient(CIO) {
        install(ContentNegotiation){
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
    val response :Weather = client.get("http://api.weatherapi.com/v1/current.json?key=b42dca6b71cc4ca393b35830260711&q=0.0,0.0").body()
    client.close()

    return response.current.temperature
}