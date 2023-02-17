package com.example.whattocooktoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.whattocooktoday.screens.MainMenu
import com.example.whattocooktoday.ui.theme.WhatToCookTodayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                MyApp {
                    MainMenu()
                }
            }
        }
    }


@Composable
fun MyApp(content: @Composable () -> Unit) {
    WhatToCookTodayTheme {

        content()

    }
}
