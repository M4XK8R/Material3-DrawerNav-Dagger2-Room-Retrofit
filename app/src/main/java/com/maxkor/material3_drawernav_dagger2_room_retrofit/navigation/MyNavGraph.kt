package com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavGraph(
    navHostController: NavHostController,
    favoriteScreenContent: @Composable () -> Unit,
    faceScreenContent: @Composable () -> Unit,
    emailScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Favorite.route
    ) {
        composable(Screen.Favorite.route) {
            favoriteScreenContent()
        }
        composable(Screen.Face.route) {
            faceScreenContent()
        }
        composable(Screen.Email.route) {
            emailScreenContent()
        }
    }
}