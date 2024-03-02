package com.nqh.a7minutesworkout

import android.app.Application
import com.nqh.a7minutesworkout.Database.HistoryDatabase

class WorkOutApp: Application() {
    val db by lazy {
        HistoryDatabase.getInstance(this)
    }
}