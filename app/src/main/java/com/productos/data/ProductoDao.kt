package com.productos.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.productos.model.Producto

@Dao
interface ProductoDao {

    //Funcion para obtener la lista de lugares
    @Query("select * from PRODUCTO")
    fun getAllData() : LiveData<List<Producto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProducto(lugar: Producto)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateProducto(lugar: Producto)

    @Delete
    suspend fun deleteProducto(lugar: Producto)
}