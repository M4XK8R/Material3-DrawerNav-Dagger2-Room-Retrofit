package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [MyEntity::class])
abstract class MyDatabase : RoomDatabase() {

    abstract fun dao(): MyDao

    companion object {

        private const val DATABASE_NAME = "db"

        @Volatile
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            instance?.let { return it }
            synchronized(this) {
                val db = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    DATABASE_NAME
                ).build()
                instance = db
                return db
            }
        }
    }
}









