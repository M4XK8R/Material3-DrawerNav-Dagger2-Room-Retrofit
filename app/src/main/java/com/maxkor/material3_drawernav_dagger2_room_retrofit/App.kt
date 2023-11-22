package com.maxkor.material3_drawernav_dagger2_room_retrofit

import android.app.Application
import com.maxkor.material3_drawernav_dagger2_room_retrofit.di.ApplicationGraph
import com.maxkor.material3_drawernav_dagger2_room_retrofit.di.DaggerApplicationGraph

class App : Application() {

    val diComponent: ApplicationGraph by lazy {
        DaggerApplicationGraph
            .factory()
            .create(this)
    }
}