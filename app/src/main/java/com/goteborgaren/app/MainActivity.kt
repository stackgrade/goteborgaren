package com.goteborgaren.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.goteborgaren.app.presentation.navigation.GoteborgarenNavHost
import com.goteborgaren.app.presentation.theme.GoteborgarenTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoteborgarenTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GoteborgarenNavHost()
                }
            }
        }
    }
}
