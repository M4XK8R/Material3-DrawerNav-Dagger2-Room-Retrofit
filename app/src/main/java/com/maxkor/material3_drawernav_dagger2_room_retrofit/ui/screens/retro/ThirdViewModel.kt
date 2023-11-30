package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class ThirdViewModel @Inject constructor(
    private val apiHelper: ApiHelper
) : ViewModel() {

    init {
        loadCoinInfo()
    }

    val coinInfo = apiHelper.coinInfo

    private fun loadCoinInfo() {
        viewModelScope.launch {
            delay(200)
            apiHelper.getBitcoinPrice()
        }
    }

}


// Flow tests functions

//    private val _coinInfo = mutableStateOf(CoinInfo.coinInfoInitial)
//    val coinInfo: State<CoinInfo> = _coinInfo
//
//    private fun loadCoinInfoHot() {
//        viewModelScope.launch {
//            apiHelper.getBitcoinPriceHot()
//                .onStart {
//                    Log.d("TAG", "onStartHot")
//                }
//                .collect {
//                    _coinInfo.value = it
//                    Log.d("TAG", "collect")
//                }
//        }
//    }
//
//    private  fun loadCoinInfoCold() {
//        apiHelper.getBitcoinPriceCold()
//            .onStart {
//                Log.d("TAG", "onStartCold")
//            }
//            .onEach {
//                _coinInfo.value = it
//            }
//            .launchIn(viewModelScope)
//    }
//}


