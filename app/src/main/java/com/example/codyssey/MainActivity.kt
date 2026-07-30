package com.example.codyssey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.codyssey.ui.CodysseyApp
import com.example.codyssey.ui.theme.CodysseyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodysseyTheme {
                CodysseyApp()
            }
        }
    }
}

