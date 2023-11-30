package com.maxkor.material3_drawernav_dagger2_room_retrofit.di

import androidx.lifecycle.ViewModel
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro.ThirdViewModel
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    @Binds
    fun bindSecondScreenViewModel(viewModel: SecondViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ThirdViewModel::class)
    @Binds
    fun bindThirdScreenViewModel(viewModel: ThirdViewModel): ViewModel

}