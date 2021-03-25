package com.fitbet.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fitbet.R
import com.fitbet.application.RicheraceApplication
import com.fitbet.data.AppDatabase
import com.fitbet.data.entity.Challenge
import com.fitbet.databinding.ActivityChallengeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChallengeActivity : AppCompatActivity() {
    @Inject
    lateinit var db: AppDatabase
    lateinit var binding: ActivityChallengeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge)

        val challengeId: Int = intent.extras?.get("CHALLENGE_ID") as Int
        binding.challengeId.text = challengeId.toString()

        (applicationContext as RicheraceApplication).mAppComponent.inject(this)

        binding.delete.setOnClickListener {
            GlobalScope.launch {
                db.challengeDao().delete(Challenge(challengeId))
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}