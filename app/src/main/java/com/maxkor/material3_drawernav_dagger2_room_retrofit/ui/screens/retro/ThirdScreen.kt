package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.CoinInfo
import kotlin.math.roundToInt

@Composable
fun ThirdScreen(coinInfo: CoinInfo) {


    Box(
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Third screen",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(100.dp))

                Text(
                    text = coinInfo.time.updated,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Text(
                    text = coinInfo.currency,
                    fontSize = 24.sp,
                    color = Color.White
                )

                Text(
                    text = coinInfo.info.usd.name,
                    fontSize = 24.sp,
                    color = Color.White
                )

                Text(
                    text = coinInfo.info.usd.value.roundToInt().toString(),
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
        }
    }
