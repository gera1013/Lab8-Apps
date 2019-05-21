package com.example.lab8.producto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Base de datos, entidad producto
@Database(entities = [Producto::class], version = 2, exportSchema = false)
abstract class ProductoDatabase : RoomDatabase() {

    abstract fun productoDao(): ProductoDao

    companion object {

        private var INSTANCE: ProductoDatabase? = null

        //Funcion de getInstance, asi se asegura de solamente crear una instancia
        fun getInstance(context: Context): ProductoDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        ProductoDatabase::class.java, "item_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}