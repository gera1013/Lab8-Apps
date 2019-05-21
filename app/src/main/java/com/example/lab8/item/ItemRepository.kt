package com.example.lab8.item

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import java.nio.file.Files.delete
import android.provider.ContactsContract.CommonDataKinds.Note
import android.provider.SyncStateContract.Helpers.update


class ItemRepository(application: Application) {

    private val itemDao: ItemDao //Se instancia el dao
    private val allItems: LiveData<List<Item>> //Lista de todos los inventarios
    private val database: ItemDatabase = ItemDatabase.getInstance(application) //Se obtiene la instancia de la base de datos

    init {
        itemDao = database.itemDao()
        allItems = itemDao.getAllItems()
    }

    //Implementacion de los metodos del dao
    fun insert(item: Item) {
        InsertItemAsyncTask(itemDao).execute(item)
    }

    fun update(item: Item) {
        UpdateItemAsyncTask(itemDao).execute(item)
    }

    fun delete(item: Item) {
        DeleteItemAsyncTask(itemDao).execute(item)
    }

    fun deleteAllItems() {
        DeleteAllItemsAsyncTask(itemDao).execute()
    }

    fun getAllItems(): LiveData<List<Item>> {
        return allItems
    }

    //Funciones asincronas para realizar acciones sin esperar a que otras terminen
    private class InsertItemAsyncTask(private val itemDao: ItemDao) :
        AsyncTask<Item, Void, Void>() {

        override fun doInBackground(vararg items: Item): Void? {
            itemDao.insert(items[0])
            return null
        }
    }

    private class UpdateItemAsyncTask(private val itemDao: ItemDao) :
        AsyncTask<Item, Void, Void>() {

        override fun doInBackground(vararg items: Item): Void? {
            itemDao.update(items[0])
            return null
        }
    }

    private class DeleteItemAsyncTask(private val itemDao: ItemDao) :
        AsyncTask<Item, Void, Void>() {

        override fun doInBackground(vararg items: Item): Void? {
            itemDao.delete(items[0])
            return null
        }
    }

    private class DeleteAllItemsAsyncTask(private val itemDao: ItemDao) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            itemDao.deleteAllItems()
            return null
        }
    }
}