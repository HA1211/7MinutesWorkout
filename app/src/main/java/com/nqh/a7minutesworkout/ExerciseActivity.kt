package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.nqh.a7minutesworkout.databinding.ActivityExerciseBinding
import com.nqh.a7minutesworkout.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {

    lateinit var binding: ActivityExerciseBinding

    private lateinit var restTimer: CountDownTimer
    private var restProgress = 0
    private var restProgressExercise = 0
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarExercise)

        setRestProgress()

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding.toolbarExercise.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun setRestProgress(){
        binding.progressBar.progress = restProgress

        restTimer = object: CountDownTimer(10000, 1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 10 - restProgress
                binding.tvTimer.text = (10 - restProgress).toString()

            }

            override fun onFinish() {
                binding.flProgressBar.visibility = View.INVISIBLE
                binding.tvTitle.setText("Exercise Name")
                exerciseTimer()
            }

        }.start()
    }

    private fun exerciseTimer(){
        binding.progressExercise.progress = restProgressExercise

        restTimer = object: CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                restProgressExercise++
                binding.progressExercise.progress = 30 - restProgressExercise
                binding.tvTimerExercise.text = (30 - restProgressExercise).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity,"Done", Toast.LENGTH_LONG).show()
            }
        }.start()
    }



}