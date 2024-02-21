package com.nqh.a7minutesworkout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [HistoryDao::class])
abstract class HistoryDatabase:RoomDatabase(){

    abstract val historyDao:HistoryDao
    companion object {

        private var INSTANCE: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context, HistoryDatabase::class.java, "room_note_1"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }
        }
    }
}