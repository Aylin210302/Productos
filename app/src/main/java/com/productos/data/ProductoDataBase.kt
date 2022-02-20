package com.productos.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.productos.model.Producto

@Database(entities = [Producto::class], version = 1,exportSchema = false)
abstract class ProductoDataBase : RoomDatabase(){
    abstract fun productoDao() : ProductoDao

    companion object {

        @Volatile
        private var INSTANCE: ProductoDataBase? = null

        fun getDatabase(context: android.content.Context) : ProductoDataBase {
            var instance = INSTANCE
            if (instance != null) {
                return instance
            }
            synchronized(this) {
                //Se crea el esquema de la base de datos -fisico-
                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    ProductoDataBase::class.java,
                    "Producto_database"
                ).build()
                INSTANCE = basedatos
                return basedatos
            }
        }

    }
}