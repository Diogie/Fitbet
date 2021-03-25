package com.fitbet.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fitbet.data.entity.Challenge


@Dao
interface ChallengeDao {
    @Query("SELECT * FROM Challenges")
    fun getAll(): LiveData<List<Challenge>>

    @Insert
    suspend fun insertAll(vararg challenge: Challenge)

    @Delete
    suspend fun delete(challenge: Challenge)
}