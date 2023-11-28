package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maxkor.material3_drawernav_dagger2_room_retrofit.App
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.DeleteFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.GetAllFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.InsertToDbUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val component by lazy {
        (application as App).diComponent
    }

    init {
        component.inject(this)
    }

    @Inject
    lateinit var getAllFromDbUseCase: GetAllFromDbUseCase

    @Inject
    lateinit var insertToDbUseCase: InsertToDbUseCase

    @Inject
    lateinit var deleteFromDbUseCase: DeleteFromDbUseCase

    fun getAllItems(): Flow<List<MyEntity>> {
        return getAllFromDbUseCase()
    }

    fun insertToDb(entity: MyEntity) {
        viewModelScope.launch {
            insertToDbUseCase(entity)
        }
    }

    fun deleteFromDb(entity: MyEntity) {
        viewModelScope.launch {
            deleteFromDbUseCase(entity)
        }
    }

}