package com.nqh.a7minutesworkout

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(historyDao: HistoryEntity)

    @Query("SELECT * from `history-table`")
    fun fetchAllDate(): Flow<List<HistoryEntity>>
}