package com.maxkor.material3_drawernav_dagger2_room_retrofit.di

import android.content.Context
import androidx.room.Room
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.repository.RepositoryImpl
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyDatabase
import com.maxkor.material3_drawernav_dagger2_room_retrofit.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MyModule {

    @DiAppScope
    @Binds
    fun bindMyRepository(impl: RepositoryImpl): MyRepository

    companion object {

        private const val DATABASE_NAME = "db"

        @DiAppScope
        @Volatile
        private var instance: MyDatabase? = null

        @DiAppScope
        @Provides
        fun provideDb(context: Context): MyDatabase {
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