# Day 18

## Objective
Refactor the lesson feature using the Repository Pattern and migrate UI state management from mutableStateOf to StateFlow.

## Implemented
- Created LessonRepository interface in the domain layer
- Implemented FakeLessonRepository as the first repository implementation
- Moved lesson retrieval logic into the repository
- Moved lesson completion business logic into the repository
- Updated LessonViewModel to depend on the LessonRepository interface instead of the concrete implementation
- Refactored LessonViewModel to delegate data operations to the repository
- Replaced mutableStateOf with MutableStateFlow
- Exposed immutable StateFlow using asStateFlow()
- Updated completeLesson() to emit new UI state through StateFlow
- Updated JourneyScreen to collect StateFlow using collectAsState()
- Updated LessonScreen to collect StateFlow using collectAsState()
- Verified that lesson progression and roadmap updates continue working correctly after the migration

## Learned
- Repository Pattern
- Dependency inversion using interfaces
- Separation of UI state and data layer responsibilities
- MutableStateFlow
- StateFlow
- Backing properties (_uiState and uiState)
- collectAsState()
- State emission using StateFlow
- Why StateFlow is preferred over mutableStateOf in MVVM architecture

## Files
- LessonRepository.kt
- FakeLessonRepository.kt
- LessonViewModel.kt
- JourneyScreen.kt
- LessonScreen.kt

## Next
- Introduce Dependency Injection
- Replace manual repository creation with constructor injection
- Learn ViewModel factories and dependency management
- Continue improving the MVVM architecture
