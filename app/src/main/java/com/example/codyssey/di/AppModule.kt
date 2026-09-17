package com.example.codyssey.di

import com.example.codyssey.domain.LessonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.codyssey.data.local.CodysseyDatabase
import com.example.codyssey.data.lesson.LessonDao
import com.example.codyssey.data.lesson.RoomLessonRepository
import com.example.codyssey.data.profile.RoomUserProfileRepository
import com.example.codyssey.data.profile.UserProfileDao
import com.example.codyssey.data.quest.QuestDao
import com.example.codyssey.data.quest.RoomQuestRepository
import com.example.codyssey.domain.QuestRepository
import com.example.codyssey.domain.UserProfileRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CodysseyDatabase {

        return Room.databaseBuilder(
            context,
            CodysseyDatabase::class.java,
            "codyssey_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideLessonDao(
        database: CodysseyDatabase
    ): LessonDao {

        return database.lessonDao()
    }

    @Provides
    @Singleton
    fun provideUserProfileDao(
        db: CodysseyDatabase
    ): UserProfileDao {
        return db.userProfileDao()
    }
    @Provides
    @Singleton
    fun provideLessonRepository(
        repository: RoomLessonRepository
    ): LessonRepository {
        return repository
    }

    @Provides
    @Singleton
    fun provideUserProfileRepository(
        userProfileDao: UserProfileDao
    ): UserProfileRepository {
        return RoomUserProfileRepository(userProfileDao)
    }

    @Provides
    fun provideQuestRepository(
        repository: RoomQuestRepository
    ): QuestRepository = repository

    @Provides
    @Singleton
    fun provideQuestDao(
        database: CodysseyDatabase
    ): QuestDao {
        return database.questDao()
    }
}