package com.example.kash.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class Categoria(
    @PrimaryKey(autoGenerate = true) val categoriaId: Int = 0,
    val nombre: String,
    val icono: String,
    val esIngreso: Boolean,
    val presupuestoMensual: Double = 0.0 // Para la barra de progreso de Figma
)