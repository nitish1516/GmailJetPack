package com.example.gmailjetpack.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmailjetpack.GmailApp
import com.example.gmailjetpack.R
import com.example.gmailjetpack.ui.theme.GmailJetPackTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * we need to start with scaffoldState because the drawer menu is connected to Scaffold
 * We need scaffoldState to open or close drawer
 * We need to pass scope Coroutine to know in which scope we are at
 * */
@Composable
fun HomeAppBar(scaffoldState: ScaffoldState,scope:CoroutineScope )
{
    Box(modifier=Modifier.padding(10.dp)){
        Card(
            modifier=Modifier.height(50.dp),
            shape = RoundedCornerShape(10.dp),elevation = 6.dp) {
            Row(verticalAlignment = Alignment.CenterVertically,
            modifier= Modifier
                .fillMaxSize()
                .padding(8.dp)){
                /**
                 * We need to add IconButton here so that on click of the button we can open
                 drawer
                 * */
                IconButton(onClick = {
                /**
                * we will be using Coroutine to launch scaffoldState
                */
                    scope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(Icons.Default.Menu,contentDescription = "Menu")
                }

                Text(text = "Search in Email", modifier=Modifier.weight(2.0f))
                Image(painter = painterResource(id = R.drawable.profile_image)
                    , contentDescription = "Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop)
            }
            
        }
    }
}


@Preview
@Composable
fun DefaultPreview()
{
    GmailJetPackTheme{
        GmailApp()
    }
}