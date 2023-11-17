package com.maxkor.material3_drawernav_dagger2_room_retrofit.navigation

private const val ROUTE_FAVORITE = "favorite"
private const val ROUTE_EMAIL = "email"
private const val ROUTE_FACE = "face"

sealed class Screen(val route: String) {

    object Favorite : Screen(ROUTE_FAVORITE)
    object Face : Screen(ROUTE_FACE)
    object Email : Screen(ROUTE_EMAIL)
}
