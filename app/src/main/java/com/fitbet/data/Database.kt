package com.fitbet.data
import androidx.room.*
import com.fitbet.data.entity.*

data class ChallengeWithFriends(
    @Embedded val challenge: Challenge,
    @Relation(
        parentColumn = "challengeId",
        entityColumn = "friendId",
        associateBy = Junction(ChallengeFriend::class)
    )
    val friends: List<Friend>
)
