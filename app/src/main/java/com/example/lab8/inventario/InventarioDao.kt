package com.example.lab8.inventario

import androidx.lifecycle.LiveData
import androidx.room.*

//Interfaz del dao, con las funciones basicas de una base de datos room
@Dao
interface InventarioDao {

    @Insert
    fun insert(inventario: Inventario)

    @Update
    fun update(inventario: Inventario)

    @Delete
    fun delete(inventario: Inventario)

    @Query("DELETE FROM inventario_table")
    fun deleteAllInventarios()

    @Query("SELECT * FROM inventario_table ORDER BY id DESC")
    fun getAllInventarios() : LiveData<List<Inventario>>
}