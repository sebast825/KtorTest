package com.example.appmoviles_parcial.cotizacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appmoviles_parcial.repositorio.MockRepositorio
import com.example.appmoviles_parcial.repositorio.Repositorio
import kotlinx.coroutines.launch

//agregar view Model si no se rompe
class CotizacionViewModel : ViewModel(){

    val repositorio = MockRepositorio()
    var estado by mutableStateOf<CotizacionEstado>(CotizacionEstado.Vacio)


    fun ejecutar (intencion: CotizacionIntencion){
        when(intencion){
            CotizacionIntencion.cargarCotizacion -> cargarCotizacion()
            CotizacionIntencion.limpiar -> limpiarCotizacion()
        }
    }

    private fun cargarCotizacion(){
        estado = CotizacionEstado.Cargando

        viewModelScope.launch {

            val dolarBlue = repositorio.getDolarBlue()
            estado = CotizacionEstado.Ok(dolarBlue)
        }
    }
    private fun limpiarCotizacion(){
        estado = CotizacionEstado.Vacio

    }
}


