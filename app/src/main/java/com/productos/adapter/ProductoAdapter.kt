package com.productos.adapter

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.productos.databinding.ProductoFilaBinding
import com.productos.model.Producto
import com.productos.ui.producto.ProductoFragmentDirections

class ProductoAdapter : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    private var listaProductos = emptyList<Producto>()

    fun setData(productos : List<Producto>){
        this.listaProductos = productos
        notifyDataSetChanged()
    }

    inner class ProductoViewHolder(private val itemBinding: ProductoFilaBinding)
        : RecyclerView.ViewHolder(itemBinding.root){

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}