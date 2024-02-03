package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.a7minutesworkout.databinding.ActivityExerciseBinding
import com.nqh.a7minutesworkout.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {

    lateinit var binding: ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}