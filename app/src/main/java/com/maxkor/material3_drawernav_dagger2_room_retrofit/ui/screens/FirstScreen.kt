package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun FirstScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Text(
                text = "First screen",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )

            AsyncImage(
                model = "https://random.imagecdn.app/500/750",
                contentDescription = null,
            )
        }

    }
}