package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavigationItem
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.coil.FirstScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro.ThirdScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room.SecondScreen

@Composable
fun MainScreen() {

    val navHelper = NavigationHelper.rememberNavigationState()

    val items = listOf(
        MyNavigationItem.Favorite,
        MyNavigationItem.Face,
        MyNavigationItem.Email,
    )

    val selectedItem = remember {
        mutableStateOf(items[0])
    }

    MyDrawer(
        contentNav = {
            MyNavGraph(
                navHostController = navHelper.navHostController,
                favoriteScreenContent = { FirstScreen() },
                faceScreenContent = { SecondScreen() },
                emailScreenContent = { ThirdScreen() }
            )
        },
        navHelper = navHelper,
        items = items,
        selectedItem = selectedItem
    )
}