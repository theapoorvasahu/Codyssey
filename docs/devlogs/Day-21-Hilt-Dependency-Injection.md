# Day 21: Hilt Dependency Injection

**Date:** 9 September 2026

---

# 🎯 Objective

Today I replaced the manual dependency injection setup in Codyssey with Hilt, Android's official dependency injection framework.

Instead of manually creating repositories and ViewModels, Hilt now manages the application's dependency graph automatically.

This concludes Sprint 2 by introducing production-ready dependency injection.

---

# 📚 What I Learned

## 1. Why Hilt?

Yesterday I implemented Manual Dependency Injection using an AppContainer.

Although it worked, I still had to manually create:

- AppContainer
- ViewModelFactory
- Repository instances

As applications grow, this becomes repetitive and difficult to maintain.

Hilt solves this by generating the dependency graph automatically during compilation.

---

## 2. Hilt Application

I created a custom Application class.

```kotlin
@HiltAndroidApp
class CodysseyApplication : Application()
```

This annotation tells Hilt where the dependency graph begins.

---

## 3. Android Entry Point

I annotated MainActivity with:

```kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity()
```

Now Android components can receive dependencies managed by Hilt.

---

## 4. Creating an App Module

Instead of AppContainer, I created an AppModule.

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule
```

A Hilt Module tells Hilt how to create dependencies.

---

## 5. Providing Dependencies

Inside AppModule I provided the LessonRepository.

```kotlin
@Provides
@Singleton
fun provideLessonRepository(): LessonRepository {
    return FakeLessonRepository
}
```

Whenever any class asks for a LessonRepository, Hilt now provides the FakeLessonRepository instance automatically.

---

## 6. Constructor Injection

LessonViewModel now receives its dependency directly through its constructor.

```kotlin
@HiltViewModel
class LessonViewModel @Inject constructor(
    private val repository: LessonRepository
) : ViewModel()
```

No ViewModelFactory is required anymore.

---

## 7. Simplified Navigation

Previously AppNavHost manually created:

- AppContainer
- Repository
- ViewModelFactory
- LessonViewModel

Now obtaining the ViewModel is simply:

```kotlin
val lessonViewModel: LessonViewModel = hiltViewModel()
```

Hilt automatically provides all required dependencies.

---

# 💻 Code Changes

- Added Hilt dependencies
- Added KSP support
- Created CodysseyApplication
- Registered the application in AndroidManifest.xml
- Added @AndroidEntryPoint to MainActivity
- Created AppModule
- Added @Provides method for LessonRepository
- Converted LessonViewModel into a @HiltViewModel
- Injected LessonRepository using constructor injection
- Removed AppContainer
- Removed LessonViewModelFactory
- Updated AppNavHost to use hiltViewModel()

---

# 💡 Biggest Takeaway

Manual Dependency Injection helped me understand how dependencies are created and passed through an application.

Hilt doesn't replace that understanding—it automates the repetitive wiring while preserving the same architecture.

Learning Manual DI before Hilt made the purpose of Hilt much clearer.

---

# 🚀 Progress

## Foundation

- ✅ Compose
- ✅ MVVM
- ✅ StateFlow
- ✅ Repository Pattern
- ✅ Dependency Injection
- ✅ Hilt
- ⏳ Room
- ⏳ DataStore

Sprint Progress:

- ✅ Sprint 1 — UI Foundation
- ✅ Sprint 2 — App Architecture

---

# 📖 Resources

- Android Developers — Hilt
- Android Developers — Dependency Injection
- Android Developers — Hilt and Jetpack
- Philipp Lackner — Hilt Tutorial
- Kotlin Official Documentation

---

# 🔜 Next Steps

Sprint 3 — Local Persistence

Next I will replace the fake repository with a Room-based repository so that Codyssey can persist user progress locally.

Topics to learn:

- Room Database
- Entity
- DAO
- Repository Implementation
- Local Persistence
