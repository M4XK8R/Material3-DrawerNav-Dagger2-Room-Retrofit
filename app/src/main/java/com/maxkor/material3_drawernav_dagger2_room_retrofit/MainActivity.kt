package com.maxkor.material3_drawernav_dagger2_room_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.DeleteFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.GetAllFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.InsertToDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.MainScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.theme.Material3DrawerNavDagger2RoomRetrofitTheme
import javax.inject.Inject

class MainActivity() : ComponentActivity() {

    private val component by lazy {
        (application as App).diComponent
    }

    @Inject
    lateinit var insertToDbUseCase: InsertToDbUseCase

    @Inject
    lateinit var getAllFromDbUseCase: GetAllFromDbUseCase

    @Inject
    lateinit var deleteFromDbUseCase: DeleteFromDbUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            Material3DrawerNavDagger2RoomRetrofitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        insertToDbUseCase = insertToDbUseCase,
                        getAllFromDbUseCase = getAllFromDbUseCase,
                        deleteFromDbUseCase = deleteFromDbUseCase
                    )
                }
            }
        }
    }
}

