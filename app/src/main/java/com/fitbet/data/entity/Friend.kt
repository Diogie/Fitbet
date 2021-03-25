package com.fitbet.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Friends")
data class Friend(
    @PrimaryKey(autoGenerate = true) val friendId: Int,
    @ColumnInfo(name = "name") val name: String
)