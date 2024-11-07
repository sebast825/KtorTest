package com.example.appmoviles_parcial.repositorio

import com.example.ktortest.repositorio.modelos.Ciudad
import com.example.ktortest.repositorio.modelos.Clima
import com.example.ktortest.repositorio.modelos.ForecastDTO
import com.example.ktortest.repositorio.modelos.ListForecast
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

class MockRepositorio : Repositorio {
    /*
    override suspend fun getDolarBlue(): Int {

        delay(1500)
        return 8
    }*/
    private val apiKey = "95e93e4f7a36fc511148468d1774792d"

    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val respuesta = cliente.get("https://api.openweathermap.org/geo/1.0/direct"){
            parameter("q",ciudad)
            parameter("limit",100)
            parameter("appid",apiKey)
        }

        if (respuesta.status == HttpStatusCode.OK){
            val ciudades = respuesta.body<List<Ciudad>>()
            return ciudades
        }else{
            throw Exception()
        }
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        val respuesta = cliente.get("https://api.openweathermap.org/data/2.5/weather"){
            parameter("lat",lat)
            parameter("lon",lon)
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val clima = respuesta.body<Clima>()
            return clima
        }else{
            throw Exception()
        }
    }

    override suspend fun traerPronostico(nombre: String): List<ListForecast> {

        val respuesta = cliente.get("https://api.openweathermap.org/data/2.5/forecast"){
            parameter("q",nombre)
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val forecast = respuesta.body<ForecastDTO>()
            return forecast.list
        }else{
            throw Exception()
        }

    }
}