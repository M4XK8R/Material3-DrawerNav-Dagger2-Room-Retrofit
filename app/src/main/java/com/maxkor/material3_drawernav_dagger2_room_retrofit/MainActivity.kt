package com.maxkor.material3_drawernav_dagger2_room_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.MyViewModelFactory
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.MainScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.theme.Material3DrawerNavDagger2RoomRetrofitTheme
import javax.inject.Inject

class MainActivity() : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).diComponent.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            Material3DrawerNavDagger2RoomRetrofitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModelFactory)
                }
            }
        }
    }
}

