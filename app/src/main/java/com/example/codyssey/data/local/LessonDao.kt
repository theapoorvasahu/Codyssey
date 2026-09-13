package com.example.codyssey.data.local
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LessonDao {
    @Query("SELECT * FROM lessons")
    fun getLessons(): List<LessonEntity>

    @Query("SELECT * FROM lessons WHERE id = :id")
    fun getLesson(id: Int): LessonEntity?

    @Update
    fun updateLesson(lesson: LessonEntity)

    @Insert
    fun insertLesson(lesson: LessonEntity)
}