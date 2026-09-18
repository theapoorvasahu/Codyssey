package com.example.codyssey.data.lesson

import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.domain.QuestRepository
import com.example.codyssey.domain.UserProfileRepository
import com.example.codyssey.model.Lesson
import com.example.codyssey.model.LessonState
import javax.inject.Inject


class RoomLessonRepository @Inject constructor(
    private val lessonDao: LessonDao,
    private val questRepository: QuestRepository,
    private val userProfileRepository: UserProfileRepository
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

        if (lesson.state == LessonState.Completed) {
            return
        }

        val updatedLesson = lesson.copy(
            state = LessonState.Completed
        )

        lessonDao.updateLesson(updatedLesson)

        userProfileRepository.recordLessonCompleted()

        val questLessons = lessonDao.getLessonsForQuest(
            lesson.questId
        )

        val allCompleted = questLessons.all {
            it.state == LessonState.Completed
        }

        if (allCompleted) {

            questRepository.completeQuest(
                lesson.questId
            )

            questRepository.unlockQuest(
                lesson.questId + 1
            )

            val quest = questRepository.getQuest(
                lesson.questId
            ) ?: return

            userProfileRepository.addXp(
                quest.xpReward
            )
        }
    }

    private suspend fun seedDatabaseIfNeeded() {

        if (lessonDao.getLessonCount() == 0) {

            lessonDao.insertLessons(
                LessonSeedData.defaultLessons.map { it.toEntity() }
            )

        }

    }
}