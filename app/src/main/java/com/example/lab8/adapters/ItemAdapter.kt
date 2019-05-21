package com.example.lab8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.R
import com.example.lab8.item.Item

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemHolder>(){
    private var items: List<Item> = ArrayList() //Lista de todos los items de un inventario

    //Clase viewHolder, se definen los elementos dentro de cada posicion del recyclerView
    class ItemHolder(itemView:View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var nombreProducto : TextView = itemView.findViewById(R.id.nombreProducto)
        var cantidadProducto : TextView = itemView.findViewById(R.id.cantidadProducto)
        var botonMas : Button = itemView.findViewById(R.id.botonMas)
        var botonMenos : Button = itemView.findViewById(R.id.botonMenos)

        override fun onClick(v: View?) {}
    }

    //Se pasa el layout a usarse en el recyclerView, item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val contentView = LayoutInflater.from(parent.context).inflate(R.layout.item, null)
        return ItemHolder(contentView)
    }

    //Se hace el bind con el holder que contiene los elementos de cada item del recyclerView
    //Texto del nombre, texto de cantidad y botones de mas y menos
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemProducto = items[position]
        holder.nombreProducto.text = itemProducto.getProducto()
        holder.cantidadProducto.text = itemProducto.getCantidad().toString()
        holder.botonMas.setOnClickListener{
            val numero = itemProducto.getCantidad() + 1
            itemProducto.setCantidad(numero)
            holder.cantidadProducto.text = itemProducto.getCantidad().toString()
        }
        holder.botonMenos.setOnClickListener{
            var numero = itemProducto.getCantidad() - 1
            if(numero >= 0) itemProducto.setCantidad(numero)
            else{
                numero = 0
                itemProducto.setCantidad(numero)
            }
            holder.cantidadProducto.text = itemProducto.getCantidad().toString()
        }
    }

    override fun getItemCount() = items.size

    //Metodo de set para una nueva lista de Items
    fun setItems(items: List<Item>){
        this.items = items
        notifyDataSetChanged()
    }

    //Devuelve el item de una posicion definida
    fun getItemAt(position: Int): Item {
        return items[position]
    }

}