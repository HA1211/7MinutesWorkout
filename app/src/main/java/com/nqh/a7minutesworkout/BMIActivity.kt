package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nqh.a7minutesworkout.databinding.ActivityBmiBinding
import com.nqh.a7minutesworkout.databinding.DialogCustomBackConfirmationBinding

class BMIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarBmiActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //set back button
        supportActionBar?.title = "CALCULATE BMI" //set title in the action bar
        binding.toolbarBmiActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}