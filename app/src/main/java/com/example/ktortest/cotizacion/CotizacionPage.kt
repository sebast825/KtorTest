package com.example.appmoviles_parcial.cotizacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CotizacionPage() {

    val viewModel : CotizacionViewModel = viewModel()

    CotizacionView(
        estado = viewModel.estado
    ) {
        viewModel.ejecutar(it)
    }
}
