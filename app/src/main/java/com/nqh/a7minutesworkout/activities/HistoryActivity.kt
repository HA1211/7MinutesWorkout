package com.nqh.a7minutesworkout.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nqh.a7minutesworkout.Database.HistoryDao
import com.nqh.a7minutesworkout.Database.HistoryDatabase
import com.nqh.a7minutesworkout.Database.HistoryEntity
import com.nqh.a7minutesworkout.DateUtils
import com.nqh.a7minutesworkout.WorkOutApp
import com.nqh.a7minutesworkout.adapter.HistoryAdapter
import com.nqh.a7minutesworkout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

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

        val dao = (application as WorkOutApp).db.historyDao()
        getAllCompletedDates(dao)
    }


    private fun getAllCompletedDates(historyDao: HistoryDao){
        /*lifecycleScope.launch {
            historyDao.getAllDate().collect{ allCompletedDatesList ->
                if(allCompletedDatesList.isNotEmpty()){
                    binding.tvHistory.visibility = View.VISIBLE
                    binding.rvHistory.visibility = View.VISIBLE
                    binding.tvNoDataAvailable.visibility = View.GONE

                    val dates = ArrayList<String>()
                    for(date in allCompletedDatesList){
                        dates.add(date.date)
                    }
                    val historyAdapter = HistoryAdapter(dates)

                    binding.rvHistory.adapter = historyAdapter

                }else{
                    binding.tvHistory.visibility = View.GONE
                    binding.rvHistory.visibility = View.GONE
                    binding.tvNoDataAvailable.visibility = View.VISIBLE
                }

            }
        }*/

        CoroutineScope(Dispatchers.IO).launch {
            HistoryDatabase.getInstance(this@HistoryActivity).historyDao().insert(
                HistoryEntity(DateUtils.getDate()
                )
            )
        }
        binding.tvHistory.visibility = View.VISIBLE
        binding.rvHistory.visibility = View.VISIBLE
        binding.tvNoDataAvailable.visibility = View.GONE
    }
}