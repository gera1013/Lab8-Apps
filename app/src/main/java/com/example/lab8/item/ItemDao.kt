package com.example.lab8.item

import androidx.lifecycle.LiveData
import androidx.room.*

//Interfaz del dao, con las funciones basicas de una base de datos room
@Dao
interface ItemDao {

    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("DELETE FROM item_table")
    fun deleteAllItems()

    @Query("SELECT * FROM item_table ORDER BY id DESC")
    fun getAllItems() : LiveData<List<Item>>
}