package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit

import retrofit2.Call
import retrofit2.http.GET

private const val END_POINT_URL = "bpi/currentprice.json"
private const val END_POINT_URL2 = "data?drilldowns=Nation&measures=Population"

interface ApiService {

    @GET(END_POINT_URL)
//    suspend fun getBitcoinPrice(): CoinInfo
    suspend fun getBitcoinPrice() : CoinInfo

}