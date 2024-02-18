package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.nqh.a7minutesworkout.databinding.ActivityExerciseBinding
import com.nqh.a7minutesworkout.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0


    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0

    private lateinit var exerciseList: ArrayList<ExerciseModel>
    private var currentExercisePosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarExercise)


        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding.toolbarExercise.setNavigationOnClickListener {
            onBackPressed()
        }


        exerciseList = Constants.defaultExerciseList()

        setupRestView()


    }


    private fun setupRestView() {

        binding.flProgressBar.visibility = View.VISIBLE
        binding.tvRestTimer.visibility = View.VISIBLE
        binding.tvTitle.visibility = View.VISIBLE
        binding.tvExercise.visibility = View.VISIBLE

        binding.flExercise.visibility = View.INVISIBLE
        binding.tvExerciseName.visibility = View.INVISIBLE
        binding.ivImage.visibility = View.INVISIBLE


        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }

        binding.tvExercise.text = exerciseList!![currentExercisePosition + 1].getName()


        setRestProgressBar()

    }


    private fun setRestProgressBar() {

        binding.progressBar.progress = restProgress

        restTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 3 - restProgress
                binding.tvTimer.text = (3 - restProgress).toString()

            }

            override fun onFinish() {
                currentExercisePosition++
                setupExerciseView()
            }
        }.start()
    }


    private fun setupExerciseView() {

        binding.flProgressBar.visibility = View.INVISIBLE
        binding.tvRestTimer.visibility = View.INVISIBLE
        binding.tvTitle.visibility = View.INVISIBLE
        binding.tvExercise.visibility = View.INVISIBLE

        binding.flExercise.visibility = View.VISIBLE
        binding.tvExerciseName.visibility = View.VISIBLE
        binding.ivImage.visibility = View.VISIBLE


        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        binding.ivImage.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding.tvExerciseName.text = exerciseList!![currentExercisePosition].getName()

        setExerciseProgressBar()
    }


    private fun setExerciseProgressBar() {
        binding.progressBarExercise.progress = exerciseProgress

        exerciseTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding.progressBarExercise.progress = 10 - exerciseProgress
                binding.tvTimerExercise.text = (10 - exerciseProgress).toString()
            }

            override fun onFinish() {
                if(currentExercisePosition < exerciseList.size - 1){
                    setupRestView()
                }else{
                    Toast.makeText(this@ExerciseActivity, "Congratulations !", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }

}