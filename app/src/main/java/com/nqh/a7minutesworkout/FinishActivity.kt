package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        addDateToDatabase()
    }

    private fun addDateToDatabase() {

        val c = Calendar.getInstance()
        val dateTime = c.time
        Log.e("Date : ", "" + dateTime)

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.e("Formatted Date : ", "" + date)


        CoroutineScope(Dispatchers.IO).launch {
            HistoryDatabase.getInstance(this@FinishActivity).historyDao.insert(HistoryEntity(date))
        }


    }

}