package com.example.lab8.producto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ProductoViewModel(application: Application) : AndroidViewModel(application){
    private val repository: ProductoRepository = ProductoRepository(application) //Se crea el repositorio
    private val allProducts: LiveData<List<Producto>> = repository.getAllItems() //Se obtienen la lista del repositorio

    //Implementacion de los metodos del repositorio
    fun insert(producto: Producto){
        repository.insert(producto)
    }

    fun update(producto: Producto){
        repository.update(producto)
    }

    fun delete(producto: Producto){
        repository.delete(producto)
    }

    fun deleteAllProducts(){
        repository.deleteAllItems()
    }

    fun getAllProducts(): LiveData<List<Producto>> {
        return allProducts
    }
}
