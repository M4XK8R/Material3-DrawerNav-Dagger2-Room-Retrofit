package com.maxkor.material3_drawernav_dagger2_room_retrofit.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention
annotation class ViewModelKey(val value : KClass<out ViewModel>)
