package com.example.lab8.inventario

import androidx.room.Entity
import androidx.room.PrimaryKey

//Tabla para el view model de inventario
@Entity(tableName = "inventario_table")
class Inventario(private var fecha: String){

    //El id se genera de manera automatica
    //Variable de fecha
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    fun getFecha(): String{
        return fecha
    }

    fun getId(): Int{
        return id
    }

    fun setFecha(fecha: String){
        this.fecha = fecha
    }

    fun setId(id: Int){
        this.id = id
    }

    override fun toString(): String {
        return "$id. Inventario de $fecha"
    }

}