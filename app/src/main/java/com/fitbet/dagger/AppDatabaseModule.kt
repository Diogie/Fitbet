package com.fitbet.dagger

import android.content.Context
import androidx.room.Room
import com.fitbet.data.AppDatabase
import com.fitbet.data.dao.ChallengeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDatabaseModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideChallengeDao(db: AppDatabase): ChallengeDao { return db.challengeDao() }

    @Singleton
    @Provides
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").build()
    }
}