package com.maxkor.material3_drawernav_dagger2_room_retrofit.di

import android.content.Context
import com.maxkor.material3_drawernav_dagger2_room_retrofit.MainActivity
import dagger.BindsInstance
import dagger.Component

@DiAppScope
@Component(
    modules = [
        DatabaseModule::class,
        RemoteDataSourceModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationGraph {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface ComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationGraph
    }
}