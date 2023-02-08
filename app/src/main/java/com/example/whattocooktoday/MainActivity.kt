package com.example.whattocooktoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whattocooktoday.navigation.MyNavigation
import com.example.whattocooktoday.ui.theme.WhatToCookTodayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                MyApp {
                    MyNavigation()
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