package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.nqh.a7minutesworkout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHistory)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "HISTORY"

        binding.toolbarHistory.setNavigationOnClickListener {
            onBackPressed()
        }

        val dao = (application as WorkOutApp).db.historyDao()
        getAllCompletedDates(dao)
    }


    private fun getAllCompletedDates(historyDao: HistoryDao){
        lifecycleScope.launch {
            historyDao.fetchAllDate().collect{allCompletedDatesList ->
                for (i in allCompletedDatesList){
                    Log.e("Date: ",""+i)
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}