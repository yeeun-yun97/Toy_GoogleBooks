package com.github.yeeun_yun97.clone.googlebook.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData

@Database(entities = [BookData::class], version = 1)
abstract class FavRoom : RoomDatabase() {

    companion object {
        // singleton
        private lateinit var database: FavRoom

        fun openDatabase(applicationContext: Context) {
            if (!this::database.isInitialized) {
                database = Room.databaseBuilder(
                    applicationContext,
                    FavRoom::class.java,
                    "fav_database"
                ).build()
            }
        }

        fun getDao(): FavDao = database.getDao()

        fun closeDatabase() {
            if (database.isOpen) {
                this.database.close()
            }
        }
    }

    abstract fun getDao(): FavDao
}