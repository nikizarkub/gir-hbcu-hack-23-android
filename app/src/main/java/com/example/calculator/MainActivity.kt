package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forwardButton = findViewById<Button>(R.id.launchButton);

        forwardButton.setOnClickListener {
            launchCalculatorActivity();
        }
    }

    private fun launchCalculatorActivity() {
        val changePage = Intent(this, CalculatorActivity::class.java)
        startActivity(changePage)
    }

}