package com.example.codyssey.di

import com.example.codyssey.data.FakeLessonRepository
import com.example.codyssey.domain.LessonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLessonRepository(): LessonRepository {
        return FakeLessonRepository
    }
}