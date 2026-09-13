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
import com.example.codyssey.data.local.LessonDao
import com.example.codyssey.data.local.RoomLessonRepository

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
    fun provideLessonRepository(
        repository: RoomLessonRepository
    ): LessonRepository {
        return repository
    }
}