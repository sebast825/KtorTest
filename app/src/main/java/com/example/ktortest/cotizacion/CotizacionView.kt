package com.example.appmoviles_parcial.cotizacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun  CotizacionView (
    modifier: Modifier = Modifier,
    estado: CotizacionEstado,
    ejecutar: (CotizacionIntencion) -> Unit
){
    Scaffold {
        Column(
            modifier = modifier.padding(it)
        ){
            when(estado){
                is CotizacionEstado.Cargando -> Cargando()
                is CotizacionEstado.Error -> Error()
                is CotizacionEstado.Ok -> Cotizacion(dolarBlue = estado.dolarBlue)
                is CotizacionEstado.Vacio -> Text(text = "Limpiado")

            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                ejecutar(CotizacionIntencion.cargarCotizacion)
            }) {
                Text(text = "Refrescar")
            }
            Button(onClick = {
                ejecutar(CotizacionIntencion.limpiar)
            }) {
                Text(text = "Limpiar")
            }
        }


        
    }

}

@Composable
fun Cargando(){
    Text(text = "Cargando")

}

@Composable
fun Error(){
    Text(text = "Error")

}

@Composable
fun Cotizacion(dolarBlue : Int){

    Text(text = "La cotizacion del dia es $dolarBlue")
}