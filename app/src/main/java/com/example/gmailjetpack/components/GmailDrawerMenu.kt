package com.example.gmailjetpack.components

import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailjetpack.DrawerMenuData

@Composable
fun GmailDrawerMenu(scrollState:ScrollState)
{
    val menuDataList= listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.AllMail,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Setting,
        DrawerMenuData.Help,
    )
    Column (modifier = Modifier.verticalScroll(scrollState)){
        Text(text = "Gmail",modifier = Modifier.padding(start = 20.dp,top=20.dp),
            fontWeight = FontWeight.Bold,
            color= Color.Red,
            fontSize = 20.sp
        )

        menuDataList.forEach{
            item->
            when{
                item.isDivider->
                {
                    Divider(modifier = Modifier.padding(bottom = 8.dp,top=8.dp))
                }
                item.isHeader->
                {
                    Text(text = item.title!!,fontWeight = FontWeight.Light,
                    modifier=Modifier.padding(start = 16.dp,top = 8.dp,bottom = 8.dp))
                }
                else->
                {
                    showMenuData(item=item)
                }
            }

        }
    }

}


@Composable
fun showMenuData(item:DrawerMenuData)
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(start = 16.dp, top = 16.dp))
    {
        Image(imageVector = item.icon!!,
            contentDescription =item.title!!,
        modifier = Modifier.weight(0.5f))
        Text(text = item.title!!,
        modifier = Modifier.weight(2.0f),
        fontSize=14.sp,
        color= Color.Black)


    }
}