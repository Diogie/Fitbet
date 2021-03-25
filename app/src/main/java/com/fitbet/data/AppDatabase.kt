package com.fitbet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fitbet.data.dao.ChallengeDao
import com.fitbet.data.dao.ChallengeFriendDao
import com.fitbet.data.dao.FriendDao
import com.fitbet.data.entity.Challenge
import com.fitbet.data.entity.ChallengeFriend
import com.fitbet.data.entity.Friend

@Database(entities = [Challenge::class, Friend::class, ChallengeFriend::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun challengeDao(): ChallengeDao
    abstract fun challengeFriendDao(): ChallengeFriendDao
    abstract fun friendDao(): FriendDao
}