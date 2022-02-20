package com.productos.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Producto")

data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "descripcion")
    val descripcion: String?,
    @ColumnInfo(name = "categoria")
    val categoria: String?,
    @ColumnInfo(name = "precio")
    val precio: String?,
) : Parcelable
