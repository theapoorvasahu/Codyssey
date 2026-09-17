package com.example.codyssey.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.codyssey.data.lesson.LessonDao
import com.example.codyssey.data.lesson.LessonEntity
import com.example.codyssey.data.profile.UserProfileDao
import com.example.codyssey.data.profile.UserProfileEntity
import com.example.codyssey.data.quest.QuestDao
import com.example.codyssey.data.quest.QuestEntity


@Database(
    entities = [LessonEntity::class,
        UserProfileEntity::class,
        QuestEntity::class],
    version = 2
)
@TypeConverters(LessonStateConverter::class)
abstract class CodysseyDatabase : RoomDatabase() {

    abstract fun lessonDao(): LessonDao

    abstract fun userProfileDao(): UserProfileDao

    abstract fun questDao(): QuestDao
}