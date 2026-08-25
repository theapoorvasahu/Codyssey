# Day 16 — Lesson MVVM & State Updates

## What I built

Today I implemented the MVVM foundation for the Lesson feature and connected it to the Journey screen.

### Architecture

- Created `FakeLessonRepository`
- Created `LessonUiState`
- Created `LessonViewModel`
- Connected `JourneyScreen` with `LessonViewModel`

### State Management

Implemented immutable state updates using:

- `map()`
- `copy()`
- Compose `mutableStateOf`

Instead of modifying lesson objects directly, a new list is created whenever a lesson is completed.

### Lesson Progression

Implemented lesson progression logic:

- Current lesson becomes Completed.
- Next lesson becomes Current.
- Remaining lessons stay Locked.

### Journey Screen

The roadmap now observes the ViewModel state.

Clicking a roadmap node calls:

```kotlin
viewModel.completeLesson(lesson.id)
```

which updates the UI automatically through Compose recomposition.

## Concepts Learned

- MVVM architecture
- Immutable state updates
- Kotlin `map()`
- Data class `copy()`
- Compose recomposition
- Single source of truth

## Next

- Navigate from Journey → Lesson screen
- Display lesson content
- Complete lessons from the Lesson screen
