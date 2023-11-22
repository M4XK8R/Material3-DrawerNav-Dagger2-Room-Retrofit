package com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.usecases

import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFromDbUseCase @Inject constructor(
    private val repository: MyRepository
) {

     operator fun invoke() :  Flow<List<MyEntity>> {
        return repository.getAllFromRoom()
    }

}