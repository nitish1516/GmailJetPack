package com.example.gmailjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailjetpack.components.HomeAppBar
import com.example.gmailjetpack.ui.theme.GmailJetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    /**
     * A scaffold is a layout that provides a lot of Material Design like AppBar
     * If we hover over Scaffold we will be able to see different options
     * */
    Scaffold(topBar = { HomeAppBar() }) {
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailJetPackTheme {
        GmailApp()
    }
}