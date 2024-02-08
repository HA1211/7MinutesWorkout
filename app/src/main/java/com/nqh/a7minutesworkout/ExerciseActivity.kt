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

    private lateinit var exerciseList: ArrayList<ExerciseModel>
    private var currentExercisePosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarExercise)


        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        exerciseList = Constants.defaultExerciseList()

        binding.toolbarExercise.setNavigationOnClickListener {
            onBackPressed()
        }


        setupRestView()


    }


    private fun setupRestView(){

        binding.flProgressBar.visibility = View.INVISIBLE
        binding.tvRestTimer.visibility = View.INVISIBLE

        binding.flExercise.visibility = View.VISIBLE
        binding.tvExercise.visibility = View.VISIBLE
        binding.ivExercise.visibility = View.VISIBLE



        binding.ivExercise.setImageResource(exerciseList!![currentExercisePosition].getImage())

    }


    private fun setRestProgress(){
        binding.progressBar.progress = restProgress

        restTimer = object: CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 3 - restProgress
                binding.tvTimer.text = (3 - restProgress).toString()

            }
            override fun onFinish() {
                currentExercisePosition++
                exerciseTimer()
            }
        }.start()
    }

    private fun exerciseTimer(){
        binding.progressExercise.progress = restProgressExercise

        restTimer = object: CountDownTimer(10000, 1000){
            override fun onTick(p0: Long) {
                restProgressExercise++
                binding.progressExercise.progress = 10 - restProgressExercise
                binding.tvTimerExercise.text = (10 - restProgressExercise).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity,"Done", Toast.LENGTH_LONG).show()
            }
        }.start()
    }



}