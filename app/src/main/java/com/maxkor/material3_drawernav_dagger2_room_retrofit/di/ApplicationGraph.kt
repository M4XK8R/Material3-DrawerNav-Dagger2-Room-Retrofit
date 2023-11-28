package com.maxkor.material3_drawernav_dagger2_room_retrofit.di

import android.content.Context
import com.maxkor.material3_drawernav_dagger2_room_retrofit.MainActivity
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.retro.ThirdViewModel
import com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room.SecondViewModel
import dagger.BindsInstance
import dagger.Component

@DiAppScope
@Component(
    modules = [
        DatabaseModule::class,
        RemoteDataSourceModule::class
    ]
)
interface ApplicationGraph {

    fun inject(mainActivity: MainActivity)

    fun inject(secondViewModel: SecondViewModel)

    fun inject(thirdViewModel: ThirdViewModel)

    @Component.Factory
    interface ComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationGraph
    }
}