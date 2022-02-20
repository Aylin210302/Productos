package com.productos.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.productos.data.ProductoDao
import com.productos.model.Producto

class ProductoRepository(private val productoDao: ProductoDao) {
    val getAllData : LiveData<List<Producto>> = productoDao.getAllData()

    suspend fun addProducto(producto: Producto){
        productoDao.addProducto(producto)
    }

    suspend fun updateProducto(producto: Producto){
        productoDao.updateProducto(producto)
    }

    suspend fun deleteProducto(producto: Producto){
        productoDao.deleteProducto(producto)
    }
}