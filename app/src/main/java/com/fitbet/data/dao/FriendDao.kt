package com.fitbet.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fitbet.data.entity.Friend

@Dao
interface FriendDao {

    @Query("SELECT * FROM Friends")
    fun getAll(): List<Friend>

    @Insert
    fun insertAll(vararg friend: Friend)

    @Delete
    fun delete(friend: Friend)
}