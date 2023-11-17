package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.runtime.Composable
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper

@Composable
fun MainScreen() {

    val navHelper = NavigationHelper.rememberNavigationState()

    MyDrawer(
        contentNav = {
            MyNavGraph(
                navHostController = navHelper.navHostController,
                favoriteScreenContent = { FirstScreen() },
                faceScreenContent = { SecondScreen() },
                emailScreenContent = { ThirdScreen() }
            )
        },
        navHelper = navHelper
    )
}