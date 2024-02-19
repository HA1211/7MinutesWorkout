package com.nqh.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.util.toHalf
import com.nqh.a7minutesworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

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

        binding.btnCalculate.setOnClickListener {
            if(check()){
                val weight: Float = binding.edtWeight.text.toString().toFloat()

                val height: Float = binding.edtHeight.text.toString().toFloat() / 100

                val equal = weight / (height * height)
                result(equal)
            }else{
                Toast.makeText(this@BMIActivity,"Please enter again", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun result(equal: Float){
        val bmiType: String
        val bmiAdvive: String

        if (equal.compareTo(15f) <= 0) {
            bmiType = "Thiếu cân trầm trọng"
            bmiAdvive = "Ăn nhiều lên"
        } else if (equal.compareTo(15f) > 0 && equal.compareTo(16f) <= 0
        ) {
            bmiType = "Thiếu cân"
            bmiAdvive = "Ăn nhiều lên"
        } else if (equal.compareTo(16f) > 0 && equal.compareTo(18.5f) <= 0
        ) {
            bmiType = "Dưới tiêu chuẩn"
            bmiAdvive = "Ăn nhiều lên"
        } else if (equal.compareTo(18.5f) > 0 && equal.compareTo(25f) <= 0
        ) {
            bmiType = "Bình thường"
            bmiAdvive = "Congratulations! You are in a good shape!"
        } else if (java.lang.Float.compare(equal, 25f) > 0 && java.lang.Float.compare(
                equal,
                30f
            ) <= 0
        ) {
            bmiType = "Thừa cân"
            bmiAdvive = "Bạn nên tập thể dục"
        } else if (equal.compareTo(30f) > 0 && equal.compareTo(35f) <= 0
        ) {
            bmiType = "Obese Class I (Moderately obese)"
            bmiAdvive = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (equal.compareTo(35f) > 0 && equal.compareTo(40f) <= 0
        ) {
            bmiType = "Obese Class II (Severely obese)"
            bmiAdvive = "OMG! You are in a very dangerous condition! Act now!"
        } else {
            bmiType = "Obese Class III (Very Severely obese)"
            bmiAdvive = "OMG! You are in a very dangerous condition! Act now!"
        }

        val equalFormat = BigDecimal(equal.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding.linearBMIResult.visibility = View.VISIBLE
        binding.tvBMIValue.text = equalFormat
        binding.tvBMIType.text = bmiType
        binding.tvBMIAdvice.text = bmiAdvive

    }

    private fun check(): Boolean{
        if (binding.edtHeight.toString().isEmpty()){
            return false
        }
        else if(binding.edtWeight.toString().isEmpty()){
            return false
        }
        return true
    }

}