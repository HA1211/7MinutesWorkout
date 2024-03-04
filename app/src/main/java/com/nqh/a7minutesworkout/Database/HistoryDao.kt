package com.nqh.a7minutesworkout.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(historyDao: HistoryEntity)

    @Query("SELECT * from history_table")
    fun getAllDate(): MutableList<HistoryEntity>
}