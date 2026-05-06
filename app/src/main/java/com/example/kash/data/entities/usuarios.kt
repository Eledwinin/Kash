package com.example.kash.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val usuarioId: Int = 0,
    val nombre: String,
    val saldoTotal: Double = 0.0,
    val moneda: String = "USD" // Ejemplo: USD, MXN, EUR
)