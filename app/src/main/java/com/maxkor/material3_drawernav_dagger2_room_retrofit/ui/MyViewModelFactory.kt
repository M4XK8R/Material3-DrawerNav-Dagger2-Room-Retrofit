package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxkor.material3_drawernav_dagger2_room_retrofit.di.DiAppScope
import javax.inject.Inject
import javax.inject.Provider

@DiAppScope
class MyViewModelFactory @Inject constructor(
    private val viewModelProviders:
    @JvmSuppressWildcards
    Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProviders[modelClass]?.get() as T
    }

}