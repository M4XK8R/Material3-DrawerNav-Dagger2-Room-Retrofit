package com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Table_name")
data class MyEntity(

    @ColumnInfo(name = "Title")
    val headlineContent: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)