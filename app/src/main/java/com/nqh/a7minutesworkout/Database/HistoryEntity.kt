package com.nqh.a7minutesworkout.Database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey
    val date: String
): Parcelable
