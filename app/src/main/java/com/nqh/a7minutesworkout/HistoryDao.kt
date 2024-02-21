package com.nqh.a7minutesworkout

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface HistoryDao {
    @Insert
    fun insert(historyDao: HistoryEntity): String
}