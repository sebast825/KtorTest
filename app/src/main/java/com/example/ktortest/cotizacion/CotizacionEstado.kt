package com.example.appmoviles_parcial.cotizacion

sealed class CotizacionEstado {

    data object Cargando: CotizacionEstado()
    data object Vacio: CotizacionEstado()
    data object Error: CotizacionEstado()
    data class Ok(val dolarBlue: Int) : CotizacionEstado()
}