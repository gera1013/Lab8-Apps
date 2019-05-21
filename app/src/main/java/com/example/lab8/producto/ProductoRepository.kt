package com.example.lab8.producto

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class ProductoRepository(application: Application) {

    private val productoDao: ProductoDao //Se instancia el dao
    private val allProductos: LiveData<List<Producto>> //Lista de todos los inventarios
    private val database: ProductoDatabase = ProductoDatabase.getInstance(application) //Se obtiene la instancia de la base de datos

    init {
        productoDao = database.productoDao()
        allProductos = productoDao.getAllProductos()
    }

    //Implementacion de los metodos del dao
    fun insert(producto: Producto) {
        InsertItemAsyncTask(productoDao).execute(producto)
    }

    fun update(producto: Producto) {
        UpdateItemAsyncTask(productoDao).execute(producto)
    }

    fun delete(producto: Producto) {
        DeleteItemAsyncTask(productoDao).execute(producto)
    }

    fun deleteAllItems() {
        DeleteAllItemsAsyncTask(productoDao).execute()
    }

    fun getAllItems(): LiveData<List<Producto>> {
        return allProductos
    }

    //Funciones asincronas para realizar acciones sin esperar a que otras terminen
    private class InsertItemAsyncTask(private val productoDao: ProductoDao) :
        AsyncTask<Producto, Void, Void>() {

        override fun doInBackground(vararg prods: Producto): Void? {
            productoDao.insert(prods[0])
            return null
        }
    }

    private class UpdateItemAsyncTask(private val productoDao: ProductoDao) :
        AsyncTask<Producto, Void, Void>() {

        override fun doInBackground(vararg prods: Producto): Void? {
            productoDao.update(prods[0])
            return null
        }
    }

    private class DeleteItemAsyncTask(private val productoDao: ProductoDao) :
        AsyncTask<Producto, Void, Void>() {

        override fun doInBackground(vararg prods: Producto): Void? {
            productoDao.delete(prods[0])
            return null
        }
    }

    private class DeleteAllItemsAsyncTask(private val productoDao: ProductoDao) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            productoDao.deleteAllProductos()
            return null
        }
    }
}