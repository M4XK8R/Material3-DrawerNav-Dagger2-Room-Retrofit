package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit

import androidx.compose.runtime.State
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    val coinInfo: State<CoinInfo>

    suspend fun getBitcoinPrice()

    fun getBitcoinPriceCold(): Flow<CoinInfo>

    fun getBitcoinPriceHot(): Flow<CoinInfo>

}