package com.zachary.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
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

        binding.blueButton.setOnClickListener{
            setCalTheme(themeColor.blue)
        }

        binding.redButton.setOnClickListener{
            setCalTheme(themeColor.red)
        }

        binding.pinkButton.setOnClickListener{
            setCalTheme(themeColor.pink)
        }

        binding.greenButton.setOnClickListener{
            setCalTheme(themeColor.green)
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

    private fun setCalTheme(theme: themeColor){

        if(theme == themeColor.blue){
            setTheme(R.style.Base_Theme_SimpleCalculator_Blue)
            binding.addButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.lightblue))
            binding.subButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.lightblue))
            binding.multButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.lightblue))
            binding.divButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.lightblue))
            binding.resetButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.lightblue))
            setContentView(binding.root)

        }
        else if (theme == themeColor.red){
            setTheme(R.style.Base_Theme_SimpleCalculator_Red)
            binding.addButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.red))
            binding.subButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.red))
            binding.multButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.red))
            binding.divButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.red))
            binding.resetButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.red))
            setContentView(binding.root)
        }
        else if (theme == themeColor.pink){
            binding.addButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.pink))
            binding.subButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.pink))
            binding.multButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.pink))
            binding.divButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.pink))
            binding.resetButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.pink))

        }
        else if(theme == themeColor.green){
            binding.addButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.green))
            binding.subButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.green))
            binding.multButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.green))
            binding.divButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.green))
            binding.resetButton.background.setTint(ContextCompat.getColor(applicationContext, R.color.green))
        }
    }
}

enum class operatorTypes { add, sub, mult, div}
enum class themeColor { blue, red, pink, green}