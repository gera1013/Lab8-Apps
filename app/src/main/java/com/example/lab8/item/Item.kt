package com.example.lab8.item

import androidx.room.Entity
import androidx.room.PrimaryKey

//Tabla para el view model de item
@Entity(tableName = "item_table")
class Item(private var producto: String, private var cantidad: Int) {

    //El id se genera de manera automatica
    //Variables de producto y cantidad se crean
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    fun getId(): Int{
        return id
    }

    fun getProducto(): String {
        return producto
    }

    fun getCantidad(): Int {
        return cantidad
    }

    fun setId(id: Int){
        this.id = id
    }

    fun setProducto(producto: String){
        this.producto = producto
    }

    fun setCantidad(cantidad: Int){
        this.cantidad = cantidad
    }
}