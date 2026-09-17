package com.example.codyssey.data.local

import androidx.room.TypeConverter
import com.example.codyssey.model.LessonState

class LessonStateConverter {
    @TypeConverter
    fun fromState(state: LessonState): String{
        return state.name
    }

    @TypeConverter
    fun toState(state: String) : LessonState {
        return LessonState.valueOf(state)
    }

}