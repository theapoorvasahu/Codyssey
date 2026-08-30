# Day 17

## Objective
Implement lesson navigation with route arguments and share a single ViewModel between the Journey and Lesson screens to maintain a single source of truth for lesson progression.

## Implemented
- Added Lesson screen to the Navigation graph
- Implemented dynamic navigation using `lesson/{lessonId}`
- Passed `lessonId` from JourneyScreen to LessonScreen
- Displayed lesson details based on the selected lesson
- Implemented lesson lookup using `getLesson()`
- Added lesson completion functionality
- Updated lesson state from Current → Completed
- Automatically updated the next lesson from Locked → Current
- Shared a single `LessonViewModel` between JourneyScreen and LessonScreen
- Refactored state management to use a single source of truth
- Returned to JourneyScreen after completing a lesson
- Verified lesson progression updates correctly across navigation

## Learned
- Navigation arguments in Navigation Compose
- Dynamic routes
- Passing data between destinations
- Shared ViewModel architecture
- ViewModel scoping
- Single source of truth
- State synchronization across multiple screens
- Keeping business logic inside the ViewModel

## Files
- AppNavHost.kt
- Screen.kt
- JourneyScreen.kt
- LessonScreen.kt
- LessonViewModel.kt

## Next
- Introduce a proper Repository layer
- Decouple the ViewModel from `FakeLessonRepository`
- Implement state hoisting throughout the lesson flow
- Begin building the XP and user progression system
