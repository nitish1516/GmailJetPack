package com.example.gmailjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailjetpack.components.GmailDrawerMenu
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

    val scaffoldState= rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val scrollState= rememberScrollState()
    /**
     * A scaffold is a layout that provides a lot of Material Design like AppBar
     * If we hover over Scaffold we will be able to see different options
     * */


    Scaffold(
        /**
         * It will only show drawer if we pass scaffoldState here
         */
        scaffoldState=scaffoldState,
        topBar = { HomeAppBar(scaffoldState,scope ) },
        /**
         * So now we are going to add drawer Content here by using drawerContent
         */
    drawerContent = {
        GmailDrawerMenu(scrollState)
    }) {


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailJetPackTheme {
        GmailApp()
    }
}