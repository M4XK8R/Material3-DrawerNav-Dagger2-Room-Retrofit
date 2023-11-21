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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavigationItem
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper

@Composable
fun MyDrawer(
    contentNav: @Composable () -> Unit,
    navHelper: NavigationHelper,
    items: List<MyNavigationItem>,
    selectedItem: MutableState<MyNavigationItem>
) {

    PermanentNavigationDrawer(
        drawerContent = {
            MyPermanentDrawerSheet(
                items = items,
                selectedItem = selectedItem,
                navHelper = navHelper
            )
        },
        content = { contentNav() }
    )
}

@Composable
private fun MyPermanentDrawerSheet(
    items: List<MyNavigationItem>,
    selectedItem: MutableState<MyNavigationItem>,
    navHelper: NavigationHelper
) {
    PermanentDrawerSheet(Modifier.width(240.dp)) {

        Spacer(Modifier.height(12.dp))

        items.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.icon.name) },
                selected = item == selectedItem.value,
                onClick = {
                    selectedItem.value = item
                    navHelper.navigateTo(item.screen.route)
                },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}
