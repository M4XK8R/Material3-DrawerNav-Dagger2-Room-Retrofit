package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [MyEntity::class], exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun dao(): MyDao

}









