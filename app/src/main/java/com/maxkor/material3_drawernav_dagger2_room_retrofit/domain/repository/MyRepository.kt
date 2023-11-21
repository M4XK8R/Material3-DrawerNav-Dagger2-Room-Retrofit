package com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.repository

import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import kotlinx.coroutines.flow.Flow

interface MyRepository {

    suspend fun insertToRoom(myEntity: MyEntity)

    suspend fun deleteFromRoom(myEntity: MyEntity)

    fun getAllFromRoom(): Flow<List<MyEntity>>

}