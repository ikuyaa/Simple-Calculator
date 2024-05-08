package com.zachary.simplecalculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.zachary.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Listeners
        binding.addButton.setOnClickListener{
            doMaths(operatorTypes.add)
        }

        binding.subButton.setOnClickListener{
            doMaths(operatorTypes.sub)
        }

        binding.multButton.setOnClickListener{
            doMaths(operatorTypes.mult)
        }

        binding.divButton.setOnClickListener{
            doMaths(operatorTypes.div)
        }

        binding.resetButton.setOnClickListener{
            resetCalculator()
        }
    }


    private fun getIntFromText(editText: EditText): Int{
        if(editText.text.isEmpty()){
            return 0;
        }
        else
            return Integer.parseInt(editText.text.toString())
    }

    private fun doMaths(operator: operatorTypes){
        val num1: Int = getIntFromText(binding.number1)
        val num2: Int = getIntFromText(binding.number2)

        if(num1 == 0 || num2 == 0){
            Toast.makeText(this, "Please enter a number into both fields, or use numbers higher then 0.", Toast.LENGTH_LONG).show()
        }

        if(operator == operatorTypes.add){
            val newNumber = num1 + num2
            binding.answerText.text = "Answer: ${newNumber}"
        }
        else if (operator == operatorTypes.sub){
            val newNumber = num1 - num2
            binding.answerText.text = "Answer: ${newNumber}"
        }
        else if (operator == operatorTypes.mult){
            val newNumber = num1 * num2
            binding.answerText.text = "Answer: ${newNumber}"
        }
        else if (operator == operatorTypes.div){
            val newNumber = num1.toFloat() / num2.toFloat()
            binding.answerText.text = "Answer: ${newNumber}"
        }
        else{
            binding.answerText.text = "Answer: "
        }

    }

    private fun resetCalculator(){
        binding.number1.text.clear()
        binding.number2.text.clear()
        binding.answerText.text = "Answer: "
    }
}

enum class operatorTypes { add, sub, mult, div}