package com.maxkor.material3_drawernav_dagger2_room_retrofit.di

import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiFactory
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiHelper
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiHelperImpl
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.retrofit.ApiService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface RemoteDataSourceModule {

    @DiAppScope
    @Binds
    fun bindApiHelper(impl: ApiHelperImpl): ApiHelper

    companion object {

        @DiAppScope
        @Provides
        fun provideApiServiceRealization(): ApiService {
            return ApiFactory.apiService
        }

    }
}