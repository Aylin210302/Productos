package com.productos.ui.producto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.productos.R
import com.productos.databinding.FragmentProductoBinding
import com.productos.model.Producto
import com.productos.viewmodel.ProductoViewModel

class addProductoFragment : Fragment() {
    private lateinit var productoViewModel: ProductoViewModel
    private var _binding: FragmentProductoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        productoViewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        _binding = FragmentProductoBinding.inflate(inflater, container, false)

        binding.btAddProducto.setOnClickListener {
            agregarLugar()
        }

        return binding.root
    }

    private fun agregarLugar() {
        val nombre = binding.etNombre.text.toString()
        if(nombre.isNotEmpty()) {
            val descripcion = binding.etDescripcion.text.toString()
            val categoria = binding.etCategoria.text.toString()
            val precio = binding.etPrecio.text.toString()
            val producto = Producto(0, nombre, descripcion,categoria,precio)
            productoViewModel.addProducto(producto)
            Toast.makeText(requireContext(),
                getString(R.string.msg_producto_add),
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addProductoFragment_to_nav_producto)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}