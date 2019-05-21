package com.example.lab8.adapters

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab8.R
import com.example.lab8.producto.Producto


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>(){
    private var products: List<Producto> = ArrayList() //Lista de todos los productos

    //Se pasa el layout a usarse en el recyclerView, producto_item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.producto_item, parent, false)
        return ProductHolder(itemView)
    }

    //Se hace el bind con el holder que contiene los elementos de cada item del recyclerView
    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val currentProducto = products[position]
        holder.nombre_producto.text = currentProducto.getNombre()
    }

    override fun getItemCount(): Int {
        return products.size
    }

    //Metodo de set para una nueva lista de productos
    fun setProducts(prods: List<Producto>) {
        this.products = prods
        notifyDataSetChanged()
    }

    //Clase viewHolder, se definen los elementos dentro de cada posicion del recyclerView
    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre_producto: TextView = itemView.findViewById(R.id.text_view_title)
    }

    //Devuelve el elemento de una posicion especifica
    fun getProductAt(position: Int): Producto {
        return products[position]
    }
}