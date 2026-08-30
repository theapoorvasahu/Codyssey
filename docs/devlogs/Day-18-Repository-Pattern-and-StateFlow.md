# Day 18

## Objective
Refactor the lesson architecture using the Repository pattern and migrate UI state management from mutableStateOf to StateFlow.

## Implemented
- Created LessonRepository interface in the domain layer
- Moved lesson data operations into FakeLessonRepository
- Implemented getLessons()
- Implemented getLesson()
- Implemented completeLesson()
- Updated LessonViewModel to depend on LessonRepository instead of FakeLessonRepository directly
- Replaced mutableStateOf with MutableStateFlow
- Exposed immutable StateFlow using asStateFlow()
- Updated completeLesson() to emit new UI state through StateFlow
- Updated JourneyScreen to observe StateFlow using collectAsState()
- Updated LessonScreen to observe StateFlow using collectAsState()
- Preserved shared ViewModel between JourneyScreen and LessonScreen
- Verified lesson progression, navigation, and UI updates after migration

## Learned
- Repository Pattern
- Dependency on abstractions instead of concrete implementations
- Separation of UI, domain, and data layers
- MutableStateFlow
- StateFlow
- asStateFlow()
- collectAsState()
- State emission and reactive UI updates
- Why StateFlow is preferred over mutableStateOf for scalable app architecture

## Files
- LessonRepository.kt
- FakeLessonRepository.kt
- LessonViewModel.kt
- LessonScreen.kt
- JourneyScreen.kt

## Next
- Deepen understanding of StateFlow with a minimal example
- Introduce Dependency Injection principles
- Continue strengthening the app architecture
- Progress towards completing Sprint 2
