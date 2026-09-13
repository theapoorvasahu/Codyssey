package com.example.codyssey.data.local

import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.model.Lesson
import javax.inject.Inject

class RoomLessonRepository @Inject constructor(
    private val lessonDao: LessonDao
) : LessonRepository {
    override fun getLessons(): List<Lesson> {
        return lessonDao.getLessons().map { it.toLesson() }
    }

    override fun getLesson(id: Int): Lesson? {
        return lessonDao.getLesson(id)?.toLesson()
    }

    override fun completeLesson(id: Int) {

        val lesson = lessonDao.getLesson(id) ?: return

        val updatedLesson = lesson.copy(
            completed = true
        )

        lessonDao.updateLesson(updatedLesson)
    }

}