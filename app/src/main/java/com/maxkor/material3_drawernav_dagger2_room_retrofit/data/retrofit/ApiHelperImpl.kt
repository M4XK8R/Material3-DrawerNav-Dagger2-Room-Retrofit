package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    private val _coinInfo = mutableStateOf(CoinInfo.coinInfoInitial)
    override val coinInfo: State<CoinInfo> = _coinInfo

    override suspend fun getBitcoinPrice() {
        while (true) {
            _coinInfo.value = apiService.getBitcoinPrice()
            Log.d("TAG", "Get data")
            Log.d("TAG", "_coinInfo = $_coinInfo")
            delay(30_000)
        }
    }

    override fun getBitcoinPriceCold(): Flow<CoinInfo> {
        return flow {
            while (true) {
                emit(apiService.getBitcoinPrice())
                delay(30_000)
            }
        }
    }

    override fun getBitcoinPriceHot(): Flow<CoinInfo> {
        val flow = MutableSharedFlow<CoinInfo>()
        val coroutine = CoroutineScope(Dispatchers.IO)
        coroutine.launch {
            while (true) {
                flow.emit(apiService.getBitcoinPrice())
                Log.d("TAG", "Get data")
                delay(30_000)
            }
        }
        return flow
    }
}