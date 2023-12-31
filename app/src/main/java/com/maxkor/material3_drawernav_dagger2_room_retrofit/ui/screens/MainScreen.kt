package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.runtime.Composable
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavigationItem
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.MyViewModelFactory
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.coil.FirstScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro.ThirdScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room.SecondScreen

@Composable
fun MainScreen(viewModelFactory: MyViewModelFactory) {

    val navHelper = NavigationHelper.rememberNavigationState()

    val items = listOf(
        MyNavigationItem.Favorite,
        MyNavigationItem.Face,
        MyNavigationItem.Email,
    )

    MyDrawer(
        contentNav = {
            MyNavGraph(
                navHostController = navHelper.navHostController,
                favoriteScreenContent = { FirstScreen() },
                faceScreenContent = { SecondScreen(viewModelFactory) },
                emailScreenContent = { ThirdScreen(viewModelFactory) }
            )
        },
        navHelper = navHelper,
        items = items,
    )
}