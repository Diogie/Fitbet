package com.fitbet.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fitbet.data.ChallengeWithFriends
import com.fitbet.data.entity.ChallengeFriend

@Dao
interface ChallengeFriendDao {

    @Query("SELECT * FROM ChallengeFriends")
    fun getAll(): List<ChallengeFriend>

    @Query("SELECT * FROM ChallengeFriends")
    fun getChallengesWithFriends(): List<ChallengeWithFriends>

    @Insert
    fun insertAll(vararg challengeFriend: ChallengeFriend)

    @Delete
    fun delete(challengeFriend: ChallengeFriend)
}