/**
 * Adapted from https://www.youtube.com/watch?v=4DGLcL4v6Qo
 */

package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculatorActivity : AppCompatActivity() {
    private lateinit var answer: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val addButton = findViewById<Button>(R.id.addButton);
        val subtractButton = findViewById<Button>(R.id.subtractButton);
        val multiplyButton = findViewById<Button>(R.id.multiplyButton);
        val divideButton = findViewById<Button>(R.id.divideButton);

        val number1Text = findViewById<EditText>(R.id.number1);
        val number2Text = findViewById<EditText>(R.id.number2);

        answer = findViewById(R.id.answer);

        addButton.setOnClickListener {
            calculate(number1Text, number2Text, "add");
        }
        subtractButton.setOnClickListener {
            calculate(number1Text, number2Text, "sub");
        }
        multiplyButton.setOnClickListener {
            calculate(number1Text, number2Text, "mul");
        }
        divideButton.setOnClickListener {
            calculate(number1Text, number2Text, "div");
        }
    }

    private fun getIntFromText(num: TextView): Int {
        val numString = num.text.toString();
        if (numString == "") {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return numString.toInt();
    }

    private fun calculate(num1Text: TextView, num2Text: TextView, operation: String) {
        val num1 = getIntFromText(num1Text);
        val num2 = getIntFromText(num2Text);
        var ans  = when (operation) {
            "add" -> {
                num1 + num2;
            }

            "sub" -> {
                num1 - num2;
            }

            "mul" -> {
                num1 * num2;
            }

            else -> {
                num1 / num2;
            }
        }
        answer.text = ans.toString();
    }
}