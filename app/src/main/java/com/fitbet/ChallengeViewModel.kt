package com.fitbet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.fitbet.data.dao.ChallengeDao
import com.fitbet.data.entity.Challenge
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(
    private val challengeDao: ChallengeDao,
    application: Application) : AndroidViewModel(application) {

    private val challenges: LiveData<List<Challenge>> = challengeDao.getAll()

    fun getAllChallenges() : LiveData<List<Challenge>> {
        return challenges
    }

    suspend fun insert(challenge: Challenge) {
        challengeDao.insertAll(challenge)
    }
}