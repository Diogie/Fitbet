package com.fitbet.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Challenges")
data class Challenge(
    @PrimaryKey(autoGenerate = true) val challengeId: Int
)
