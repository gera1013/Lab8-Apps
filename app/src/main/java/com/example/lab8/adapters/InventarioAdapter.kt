package com.example.lab8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.R
import com.example.lab8.inventario.Inventario

class InventarioAdapter: RecyclerView.Adapter<InventarioAdapter.InventarioHolder>() {
    private var inventarios: List<Inventario> = ArrayList() //Lista de inventarios que se toma como base para el recyclerView

    //Se le pasa el layout que se utilizara, producto_item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventarioHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.producto_item, parent, false)
        return InventarioHolder(itemView)
    }

    //Se crean los elementos de cada posicion del recyclerView
    override fun onBindViewHolder(holder: InventarioHolder, position: Int) {
        val currentInventario = inventarios[position]
        holder.nombre_producto.text = currentInventario.toString()
    }

    override fun getItemCount(): Int {
        return inventarios.size
    }

    //Metodo de ser para una nueva lista de inventarios
    fun setInventarios(prods: List<Inventario>) {
        this.inventarios = prods
        notifyDataSetChanged()
    }

    //Clase de tipo holder para el inventario
    class InventarioHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre_producto: TextView = itemView.findViewById(R.id.text_view_title)
    }

    fun getProductAt(position: Int): Inventario{
        return inventarios[position]
    }
}