package com.example.kash.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "ahorros",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["usuarioId"],
            childColumns = ["usuarioId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("usuarioId")]
)
data class Ahorro(
    @PrimaryKey(autoGenerate = true) val ahorroId: Int = 0,
    val nombreMeta: String,
    val montoObjetivo: Double,
    val montoActual: Double = 0.0,
    val iconoMeta: String,
    val usuarioId: Int
)