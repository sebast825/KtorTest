package com.example.appmoviles_parcial.repositorio

import com.example.ktortest.repositorio.modelos.Ciudad
import com.example.ktortest.repositorio.modelos.Clima
import com.example.ktortest.repositorio.modelos.ListForecast

interface Repositorio {

    //suspend fun getDolarBlue() : Int
    suspend fun buscarCiudad(ciudad: String): List<Ciudad>
    suspend fun traerClima(lat: Float, lon: Float) : Clima
    suspend fun traerPronostico(nombre: String) : List<ListForecast>
}