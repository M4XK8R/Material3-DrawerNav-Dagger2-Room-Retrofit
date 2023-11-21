package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiFactory
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.CoinInfo
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyDatabase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper

@Composable
fun MainScreen() {

    var coinInfo by remember {
        mutableStateOf(CoinInfo.coinInfoInitial)
    }
    LaunchedEffect(key1 = null) {
        coinInfo = ApiFactory.apiService.getBitcoinPrice()
        Log.d("TAG", "list = $coinInfo")
    }

    val context = LocalContext.current
    val db = MyDatabase.getInstance(context)

    val navHelper = NavigationHelper.rememberNavigationState()

    MyDrawer(
        contentNav = {
            MyNavGraph(
                navHostController = navHelper.navHostController,
                favoriteScreenContent = { FirstScreen() },
                faceScreenContent = { SecondScreen(db.dao()) },
                emailScreenContent = { ThirdScreen(coinInfo) }
            )
        },
        navHelper = navHelper
    )
}