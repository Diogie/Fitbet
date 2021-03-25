package com.fitbet.dagger

import com.fitbet.application.RicheraceApplication
import com.fitbet.data.AppDatabase
import com.fitbet.ui.ChallengeActivity
import com.fitbet.ui.MainActivity
import com.fitbet.ui.NewChallengeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppDatabaseModule::class, AppModule::class])
interface AppComponent {
    fun inject(target: RicheraceApplication)
    fun inject(target: MainActivity)
    fun inject(target: NewChallengeActivity)
    fun inject(challengeActivity: ChallengeActivity)

    fun appDatabase(): AppDatabase

}