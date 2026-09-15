package com.example.codyssey.data.local
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LessonDao {

    @Query("SELECT * FROM lessons")
    suspend fun getLessons(): List<LessonEntity>

    @Query("SELECT * FROM lessons WHERE id = :id")
    suspend fun getLesson(id: Int): LessonEntity?

    @Query("SELECT COUNT(*) FROM lessons")
    suspend fun getLessonCount(): Int

    @Update
    suspend fun updateLesson(lesson: LessonEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLessons(
        lessons: List<LessonEntity>
    )

}