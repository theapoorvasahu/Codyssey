# Day 20: Manual Dependency Injection

**Date:** 7 September 2026

---

## 🎯 Objective

Today I implemented Manual Dependency Injection by introducing an App Container. The goal was to centralize dependency creation and remove knowledge of concrete implementations from the UI layer.

---

## 📚 What I Learned

### 1. What is Dependency Injection?

Dependency Injection (DI) is a design principle where objects receive their dependencies from another class instead of creating them themselves.

Instead of this:

```kotlin
private val repository = FakeLessonRepository
```

another class provides the repository.

This makes the code more modular, maintainable, and easier to replace or test.

---

### 2. App Container

I created an `AppContainer` interface that provides application-level dependencies.

```kotlin
interface AppContainer {
    val lessonRepository: LessonRepository
}
```

Then I implemented it using `DefaultAppContainer`.

```kotlin
class DefaultAppContainer : AppContainer {
    override val lessonRepository: LessonRepository =
        FakeLessonRepository
}
```

Now only one class knows which repository implementation the application uses.

---

### 3. Dependency Flow

The application's dependency graph is now:

```
AppNavHost
      │
      ▼
DefaultAppContainer
      │
      ▼
LessonRepository
      ▲
      │
FakeLessonRepository
      │
      ▼
LessonViewModelFactory
      │
      ▼
LessonViewModel
```

Each class only knows about the layer directly below it.

---

## 💻 Code Changes

- Created `AppContainer`
- Implemented `DefaultAppContainer`
- Moved repository creation into the dependency container
- Updated `AppNavHost` to use the container
- Continued using `LessonViewModelFactory` for ViewModel creation

---

## 💡 Biggest Takeaway

If I replace

```kotlin
FakeLessonRepository
```

with

```kotlin
RoomLessonRepository
```

only **DefaultAppContainer.kt** needs to change.

The ViewModel, Factory, Navigation, and UI remain completely unchanged because they depend on the `LessonRepository` interface rather than a concrete implementation.

This demonstrated the real purpose of Dependency Injection.

---

## 🚀 Progress

✅ Repository Pattern

✅ StateFlow

✅ ViewModel Factory

✅ Manual Dependency Injection

✅ App Container

Sprint 2 Progress: **98% Complete**

---

## 📖 Resources

- Android Developers — Dependency Injection Basics
- Android Developers — App Container Pattern
- Android Developers — Hilt Documentation (Preview)
- Philipp Lackner — Dependency Injection Explained
- Kotlin Official Documentation

---

## 🔜 Next Steps

- Learn Hilt
- Replace manual dependency injection with Hilt
- Understand `@Inject`, `@Module`, `@Provides`, and `@HiltViewModel`
- Complete Sprint 2
