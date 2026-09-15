package com.example.codyssey.data.local

import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.model.Lesson
import javax.inject.Inject
import com.example.codyssey.data.SeedData

class RoomLessonRepository @Inject constructor(
    private val lessonDao: LessonDao
) : LessonRepository {

    override suspend fun getLessons(): List<Lesson> {

        seedDatabaseIfNeeded()

        return lessonDao
            .getLessons()
            .map { it.toLesson() }
    }

    override suspend fun getLesson(id: Int): Lesson? {
        return lessonDao.getLesson(id)?.toLesson()
    }

    override suspend fun completeLesson(id: Int) {

        val lesson = lessonDao.getLesson(id) ?: return

        val updatedLesson = lesson.copy(
            completed = true
        )

        lessonDao.updateLesson(updatedLesson)
    }

    private suspend fun seedDatabaseIfNeeded() {

        if (lessonDao.getLessonCount() == 0) {

            lessonDao.insertLessons(
                SeedData.defaultLessons.map { it.toEntity() }
            )

        }

    }
}