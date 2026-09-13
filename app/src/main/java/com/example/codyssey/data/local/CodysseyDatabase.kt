package com.example.codyssey.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LessonEntity::class],
    version = 1
)
abstract class CodysseyDatabase : RoomDatabase() {

    abstract fun lessonDao(): LessonDao
}