# Day 19

## Objective
Decouple LessonViewModel from the concrete repository implementation by implementing manual Dependency Injection using a custom ViewModelFactory.

## Implemented
- Refactored LessonViewModel to receive LessonRepository through constructor injection
- Removed direct dependency on FakeLessonRepository from LessonViewModel
- Created LessonViewModelFactory implementing ViewModelProvider.Factory
- Implemented custom ViewModel creation inside the factory
- Added type checking using isAssignableFrom()
- Added IllegalArgumentException for unknown ViewModel classes
- Created repository instance in AppNavHost
- Created LessonViewModelFactory in AppNavHost
- Passed the custom factory to viewModel(factory = ...)
- Successfully injected LessonRepository into LessonViewModel
- Verified the application works correctly after introducing manual Dependency Injection

## Learned
- Constructor Dependency Injection
- Dependency Injection (DI)
- Inversion of Control (IoC)
- ViewModelProvider.Factory
- Custom ViewModel creation
- Why ViewModels should depend on interfaces instead of implementations
- How Android creates ViewModels internally
- Why a custom ViewModelFactory is required when a ViewModel has constructor parameters

## Files
- LessonViewModel.kt
- LessonViewModelFactory.kt
- AppNavHost.kt

## Next
- Introduce Hilt for automatic Dependency Injection
- Replace manual ViewModelFactory with Hilt-generated factories
- Learn @Inject, @Module, @Provides, @Binds and @HiltViewModel
- Understand how Hilt automates Dependency Injection
