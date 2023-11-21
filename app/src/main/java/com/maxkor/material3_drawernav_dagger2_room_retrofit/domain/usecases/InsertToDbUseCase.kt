package com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases

import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.repository.MyRepository

class InsertToDbUseCase(
    private val repository: MyRepository
) {

    suspend operator fun invoke(entity: MyEntity) {
        repository.insertToRoom(entity)
    }
}