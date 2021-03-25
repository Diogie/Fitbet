package com.fitbet.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ChallengeFriends",
    primaryKeys = ["challengeId", "friendId"]
)
data class ChallengeFriend(
    @ColumnInfo(name = "challengeId") val challengeId: Int,
    @ColumnInfo(name = "friendId") val friendId: Int
)