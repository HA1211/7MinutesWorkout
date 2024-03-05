package com.nqh.a7minutesworkout.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    fun insert(historyEntity: HistoryEntity)

    @Query("SELECT * from history_table")
    fun getAllDate(): Flow<List<HistoryEntity>>
}