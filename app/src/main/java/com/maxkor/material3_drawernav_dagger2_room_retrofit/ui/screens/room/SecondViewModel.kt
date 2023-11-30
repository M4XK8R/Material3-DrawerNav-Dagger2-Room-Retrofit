package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.DeleteFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.GetAllFromDbUseCase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases.InsertToDbUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private val getAllFromDbUseCase: GetAllFromDbUseCase,
    private val insertToDbUseCase: InsertToDbUseCase,
    private val deleteFromDbUseCase: DeleteFromDbUseCase
) : ViewModel() {

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