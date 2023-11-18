package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.platform.LocalContext
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyDatabase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper

@Composable
fun MainScreen() {

    val context = LocalContext.current
    val db = MyDatabase.getInstance(context)

    val navHelper = NavigationHelper.rememberNavigationState()

    MyDrawer(
        contentNav = {
            MyNavGraph(
                navHostController = navHelper.navHostController,
                favoriteScreenContent = { FirstScreen() },
                faceScreenContent = { SecondScreen(db.dao()) },
                emailScreenContent = { ThirdScreen() }
            )
        },
        navHelper = navHelper
    )
}