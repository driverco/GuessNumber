package com.driverco.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val generatedNumber : Int = Random.nextInt(0, 1000)
    var attempts : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun checkNumber(v: View) {
        if (numberInput.text.isEmpty()) {
            Toast.makeText(this, "value required", Toast.LENGTH_SHORT).show()
        }else{
            if (numberInput.text.toString().toInt() in 0..1000){
                attempts++
                if(numberInput.text.toString().toInt() > generatedNumber){
                    Toast.makeText(this, "your number is bigger", Toast.LENGTH_SHORT).show()
                }
                if(numberInput.text.toString().toInt() < generatedNumber){
                    Toast.makeText(this, "your number is smaller", Toast.LENGTH_SHORT).show()
                }
                if(numberInput.text.toString().toInt()  == generatedNumber){
                    Toast.makeText(this, "Bulls eye!!", Toast.LENGTH_LONG).show()
                    outputText.text = "Winner in $attempts attemps"
                }

            }else{
                Toast.makeText(this, "The number entered is not in the range", Toast.LENGTH_SHORT).show()
            }
        }
        numberInput.text.clear()
        //Toast.makeText(this, generatedNumber.toString()+":"+numberInput.text, Toast.LENGTH_SHORT).show()
    }

}