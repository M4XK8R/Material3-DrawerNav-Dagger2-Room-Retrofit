package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavigationItem
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper

@Composable
fun MyDrawer(
    contentNav: @Composable () -> Unit,
    navHelper: NavigationHelper,
    items: List<MyNavigationItem>,
) {

    PermanentNavigationDrawer(
        drawerContent = {
            MyPermanentDrawerSheet(
                items = items,
                navHelper = navHelper
            )
        },
        content = { contentNav() }
    )
}

@Composable
private fun MyPermanentDrawerSheet(
    items: List<MyNavigationItem>,
    navHelper: NavigationHelper
) {

    PermanentDrawerSheet(Modifier.width(240.dp)) {

        val navBackStackEntry by navHelper.navHostController
            .currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Spacer(Modifier.height(12.dp))

        items.forEach { item ->
            val route = item.screen.route
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.icon.name) },
                selected = currentRoute == route,
                onClick = {
                    navHelper.navigateTo(route)
                },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}
