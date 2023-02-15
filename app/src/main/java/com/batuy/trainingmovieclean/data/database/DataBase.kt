package com.batuy.trainingmovieclean.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieDb::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun dao():Dao

    companion object {
        private var db: DataBase? = null
        private const val NAME = "movie_db"
        private val LOCK = Any()

        fun getInstance(context: Context): DataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, DataBase::class.java, NAME).build()
                db = instance
                return instance
            }
        }


    }
}