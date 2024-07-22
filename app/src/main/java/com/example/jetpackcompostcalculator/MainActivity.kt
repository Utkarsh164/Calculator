package com.example.jetpackcompostcalculator


import CalculatorPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompostcalculator.ui.theme.JetpackCompostCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel=ViewModelProvider(this)[CalculatorViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            JetpackCompostCalculatorTheme {
                Scaffold (modifier = Modifier.fillMaxWidth()){
                    innerPadding->
                    CalculatorPage(modifier = Modifier.padding(innerPadding),viewModel)
                }
            }


        }
    }
}

