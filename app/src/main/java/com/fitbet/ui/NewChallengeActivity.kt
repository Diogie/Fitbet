package com.fitbet.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fitbet.R
import com.fitbet.application.RicheraceApplication
import com.fitbet.data.AppDatabase
import com.fitbet.data.entity.Challenge
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class NewChallengeActivity : AppCompatActivity() {
    @Inject
    lateinit var db: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_challenge)

        (applicationContext as RicheraceApplication).mAppComponent.inject(this)

        findViewById<Button>(R.id.create).setOnClickListener { _ ->
            GlobalScope.launch {
                db.challengeDao().insertAll(Challenge(Random.nextInt()))
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}