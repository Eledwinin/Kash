package com.example.kash.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "transacciones",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["usuarioId"],
            childColumns = ["usuarioId"],
            onDelete = ForeignKey.CASCADE // Si borras al usuario, se borran sus gastos
        ),
        ForeignKey(
            entity = Categoria::class,
            parentColumns = ["categoriaId"],
            childColumns = ["categoriaId"],
            onDelete = ForeignKey.RESTRICT // No puedes borrar una categoría si tiene gastos asociados
        )
    ],
    indices = [Index("usuarioId"), Index("categoriaId")] // Índices para que las búsquedas sean veloces
)
data class Transaccion(
    @PrimaryKey(autoGenerate = true) val transaccionId: Int = 0,
    val monto: Double,
    val descripcion: String,
    val fecha: Long,
    val tipo: String, // "INGRESO" o "GASTO"
    val usuarioId: Int,
    val categoriaId: Int
)