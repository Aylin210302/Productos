package com.productos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.productos.data.ProductoDataBase
import com.productos.model.Producto
import com.productos.repository.ProductoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductoViewModel(application: Application)
    : AndroidViewModel(application){
    val getAllData : LiveData<List<Producto>>
    private val repositorio : ProductoRepository

    init{
        val productoDao = ProductoDataBase.getDatabase(application).productoDao()
        repositorio = ProductoRepository(productoDao)
        getAllData = repositorio.getAllData
    }

    fun addProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) {repositorio.addProducto(producto)}
    }

    fun updateProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) {repositorio.updateProducto(producto)}
    }

    fun deleteProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) {repositorio.deleteProducto(producto)}
    }


}