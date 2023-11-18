package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(myEntity: MyEntity)

    @Delete
    suspend fun delete(myEntity: MyEntity)

    @Query("SELECT * FROM Table_name")
    fun getAll(): Flow<List<MyEntity>>

}