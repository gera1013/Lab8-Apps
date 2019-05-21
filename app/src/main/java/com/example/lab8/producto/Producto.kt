package com.example.lab8.producto

import androidx.room.Entity
import androidx.room.PrimaryKey

//Tabla para el view model de producto
@Entity(tableName = "product_table")
class Producto(private var nombre: String, private var codigo: String){

    //El id se genera de manera automatica
    //Variables de nombre y codigo
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0


    fun setId(id: Int){
        this.id = id
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun setCant(codigo: String){
        this.codigo = codigo
    }

    fun getId() : Int{
        return id
    }

    fun getNombre() : String{
        return nombre
    }

    fun getCodigo() : String{
        return codigo
    }

}
