package com.example.ktortest.presentacion

import com.example.ktortest.repositorio.modelos.Clima

sealed class ClimaEstado {
    data object Vacio: ClimaEstado()
    data object Cargando: ClimaEstado()
    //data class puede recibir parametro, data object mp
    data class  Exitoso(val clima: Clima): ClimaEstado()
    data class Error(val mensaje: String): ClimaEstado()
}

