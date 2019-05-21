package com.example.lab8.item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository = ItemRepository(application) //Se crea el repositorio
    private val allItems: LiveData<List<Item>> = repository.getAllItems() //Se obtienen la lista del repositorio

    //Implementacion de los metodos del repositorio
    fun insert(item: Item){
        repository.insert(item)
    }

    fun update(item: Item){
        repository.update(item)
    }

    fun delete(item: Item){
        repository.delete(item)
    }

    fun deleteAllItems(){
        repository.deleteAllItems()
    }

    fun getAllItems(): LiveData<List<Item>>{
        return allItems
    }
}