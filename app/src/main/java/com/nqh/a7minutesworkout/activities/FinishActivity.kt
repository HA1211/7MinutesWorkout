package com.nqh.a7minutesworkout.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nqh.a7minutesworkout.Database.HistoryDao
import com.nqh.a7minutesworkout.Database.HistoryDatabase
import com.nqh.a7minutesworkout.Database.HistoryEntity
import com.nqh.a7minutesworkout.DateUtils
import com.nqh.a7minutesworkout.DateUtils.getDate
import com.nqh.a7minutesworkout.WorkOutApp
import com.nqh.a7minutesworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FinishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarFinishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarFinishActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnFinish.setOnClickListener {
            finish()
        }

        val dao = (application as WorkOutApp).db.historyDao
        addDateToDatabase(dao)

    }

    private fun addDateToDatabase(historyDao: HistoryDao) {

        /*val c = Calendar.getInstance()
        val dateTime = c.time
        Log.e("Date : ", "" + dateTime)

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.e("Formatted Date : ", "" + date)*/

        /*lifecycleScope.launch {
            historyDao.insert(HistoryEntity(getDate()))
            Log.e(
                "Date: ",
                "Added:..."
            )
        }*/
        CoroutineScope(Dispatchers.IO).launch { //IO là tên luồng
            HistoryDatabase.getInstance(this@FinishActivity).historyDao.insert(
                HistoryEntity(getDate())
            )
        }
    }
}