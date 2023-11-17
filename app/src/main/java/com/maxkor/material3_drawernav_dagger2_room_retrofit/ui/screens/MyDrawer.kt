package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MyDrawer() {
    // icons to mimic drawer destinations
    val items = listOf(
        Icons.Default.Favorite,
        Icons.Default.Face,
        Icons.Default.Email
    )

    val selectedItem = remember { mutableStateOf(items[0]) }

    PermanentNavigationDrawer(
        drawerContent = {
            MyPermanentDrawerSheet(
                items = items,
                selectedItem = selectedItem
            )
        },
        content = { FirstScreen() }
    )
}

@Composable
private fun MyPermanentDrawerSheet(
    items: List<ImageVector>,
    selectedItem: MutableState<ImageVector>
) {
    PermanentDrawerSheet(Modifier.width(240.dp)) {

        Spacer(Modifier.height(12.dp))

        items.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(item, contentDescription = null) },
                label = { Text(item.name) },
                selected = item == selectedItem.value,
                onClick = {
                    selectedItem.value = item
                },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }

    }
}
