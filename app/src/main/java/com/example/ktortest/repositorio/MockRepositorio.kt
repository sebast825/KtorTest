package com.example.appmoviles_parcial.repositorio

import kotlinx.coroutines.delay

class MockRepositorio : Repositorio {
    override suspend fun getDolarBlue(): Int {

        delay(1500)
        return 8
    }
}