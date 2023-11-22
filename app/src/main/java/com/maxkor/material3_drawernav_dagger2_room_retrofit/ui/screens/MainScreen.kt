package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiFactory
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.CoinInfo
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.DeleteFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.GetAllFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.InsertToDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.MyNavigationItem
import com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation.NavigationHelper
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.coil.FirstScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro.ThirdScreen
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room.SecondScreen

@Composable
fun MainScreen(
    insertToDbUseCase: InsertToDbUseCase,
    getAllFromDbUseCase: GetAllFromDbUseCase,
    deleteFromDbUseCase: DeleteFromDbUseCase
) {

    /**
     *  NavGraph stuff
     */
    val navHelper = NavigationHelper.rememberNavigationState()

    val items = listOf(
        MyNavigationItem.Favorite,
        MyNavigationItem.Face,
        MyNavigationItem.Email,
    )

    val selectedItem = remember {
        mutableStateOf(items[0])
    }

    // First (Coil) screen stuff

    /**
     * Second (Room) screen stuff
     */
    val itemsState = getAllFromDbUseCase()
        .collectAsState(initial = emptyList())

    /**
     * Third (Retro) screen stuff
     */
    var coinInfo by remember {
        mutableStateOf(CoinInfo.coinInfoInitial)
    }
    LaunchedEffect(key1 = null) {
        coinInfo = ApiFactory.apiService.getBitcoinPrice()
    }

    // Drawer
    MyDrawer(
        contentNav = {
            MyNavGraph(
                navHostController = navHelper.navHostController,
                favoriteScreenContent = { FirstScreen() },
                faceScreenContent = {
                    SecondScreen(
                        itemsState = itemsState,
                        insertToDbUseCase = insertToDbUseCase,
                        deleteFromDbUseCase = deleteFromDbUseCase
                    )
                },
                emailScreenContent = { ThirdScreen(coinInfo = coinInfo) }
            )
        },
        navHelper = navHelper,
        items = items,
        selectedItem = selectedItem
    )
}