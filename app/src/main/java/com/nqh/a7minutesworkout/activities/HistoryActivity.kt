package com.nqh.a7minutesworkout.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nqh.a7minutesworkout.Database.HistoryDao
import com.nqh.a7minutesworkout.Database.HistoryDatabase
import com.nqh.a7minutesworkout.Database.HistoryEntity
import com.nqh.a7minutesworkout.WorkOutApp
import com.nqh.a7minutesworkout.adapter.HistoryAdapter
import com.nqh.a7minutesworkout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    var data: ArrayList<HistoryEntity>? = null

    private val adapter by lazy {
        HistoryAdapter(this@HistoryActivity, ArrayList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHistory)

        binding.rvHistory.adapter = adapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "HISTORY"

        binding.toolbarHistory.setNavigationOnClickListener {
            onBackPressed()
        }

        val dao = (application as WorkOutApp).db.historyDao
        getAllCompletedDates(dao)
    }


    private fun getAllCompletedDates(historyDao: HistoryDao) {

        CoroutineScope(Dispatchers.IO).launch {
            HistoryDatabase.getInstance(this@HistoryActivity).historyDao.getAllDate()
                .also { data = it as ArrayList<HistoryEntity> }
            runOnUiThread {
                adapter.setData(data as ArrayList<HistoryEntity>)
            }
        }
        binding.tvHistory.visibility = View.VISIBLE
        binding.rvHistory.visibility = View.VISIBLE
        binding.tvNoDataAvailable.visibility = View.GONE
    }
}