package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.repository

import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyDatabase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val db: MyDatabase
) : MyRepository {

    override suspend fun insertToRoom(myEntity: MyEntity) {
        db.dao().insert(myEntity)
    }

    override suspend fun deleteFromRoom(myEntity: MyEntity) {
        db.dao().delete(myEntity)
    }

    override fun getAllFromRoom(): Flow<List<MyEntity>> {
        return db.dao().getAll()
    }

}