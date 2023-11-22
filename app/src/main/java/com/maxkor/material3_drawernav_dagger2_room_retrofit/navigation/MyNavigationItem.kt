package com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MyNavigationItem(
    val icon: ImageVector,
    val screen: Screen
) {

    data object Favorite : MyNavigationItem(
        icon = Icons.Filled.Favorite,
        screen = Screen.Favorite
    )

    data object Face : MyNavigationItem(
        icon = Icons.Filled.Face,
        screen = Screen.Face
    )

    data object Email : MyNavigationItem(
        icon = Icons.Filled.Email,
        screen = Screen.Email
    )

}





