package com.nqh.a7minutesworkout.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [HistoryEntity::class])
abstract class HistoryDatabase : RoomDatabase() {

    abstract val historyDao: HistoryDao
    companion object {
        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context, HistoryDatabase::class.java, "room_history"
                ).fallbackToDestructiveMigration().build()
                INSTANCE= instance
                return instance
            }
        }
    }
}