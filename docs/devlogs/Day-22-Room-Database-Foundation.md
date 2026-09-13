# Day 22 — Room Database Foundation

## 🎯 Objective

Replace the in-memory lesson storage with a local Room database while preserving the existing MVVM + Repository architecture. Integrate Room using Hilt and understand how Android applications persist data locally.

---

## ✅ What Was Implemented

### 1. Added Room Dependencies

Integrated the Room persistence library into the project and configured annotation processing.

---

### 2. Created `LessonEntity`

Designed the first database entity representing the `lessons` table.

```kotlin
@Entity(tableName = "lessons")
data class LessonEntity(...)
```

Learned how entities map Kotlin objects to SQLite tables.

---

### 3. Built `LessonDao`

Implemented the Data Access Object responsible for communicating with the database.

Added support for:

- Retrieving all lessons
- Retrieving a lesson by ID
- Updating lesson progress
- Inserting new lessons

```kotlin
@Query(...)
@Insert
@Update
```

---

### 4. Created `CodysseyDatabase`

Created the application's Room database.

```kotlin
@Database(...)
abstract class CodysseyDatabase : RoomDatabase()
```

Configured the database using:

```kotlin
Room.databaseBuilder(...)
```

Also added:

```kotlin
.fallbackToDestructiveMigration()
```

to recreate the database automatically whenever the schema changes during development.

---

### 5. Implemented `RoomLessonRepository`

Created the repository implementation backed by Room.

Implemented:

- `getLessons()`
- `getLesson()`
- `completeLesson()`

The ViewModel now communicates with the repository without knowing whether the data comes from memory or a database.

---

### 6. Added Entity ↔ Domain Mapping

Created `LessonMapper.kt`.

Implemented:

- `LessonEntity.toLesson()`
- `Lesson.toEntity()`

This keeps the database layer independent from the UI layer.

---

### 7. Integrated Room with Hilt

Provided:

- Database
- DAO
- Repository

through Hilt's dependency graph.

The repository is now injected automatically instead of being created manually.

---

## 📚 Concepts Learned

Today introduced the complete local persistence layer used in modern Android applications.

### SQLite vs Room

SQLite is the actual database engine.

Room is an abstraction layer that converts Kotlin objects into SQLite operations while providing compile-time validation and type safety.

---

### Entity

An Entity represents a single table inside the database.

Each object corresponds to one row.

---

### DAO (Data Access Object)

A DAO acts as the gateway between the application and the database.

Instead of writing database logic throughout the app, all database operations are centralized inside the DAO.

---

### Repository Pattern

The Repository hides the underlying data source from the ViewModel.

Whether data comes from memory, Room, or a remote API, the ViewModel interacts with the same interface.

---

### Entity Mapping

Database models and UI models serve different purposes.

Using mappers prevents the UI layer from depending directly on database-specific classes.

---

### Hilt Dependency Injection

Hilt automatically constructs the dependency graph.

```
Application
      │
Database
      │
LessonDao
      │
RoomLessonRepository
      │
LessonRepository
      │
ViewModel
```

This eliminates manual object creation and improves scalability.

---

## 🧠 Key Takeaways

- Room is an abstraction built on top of SQLite.
- Entities represent database tables.
- DAOs contain all database operations.
- Repositories isolate the data layer from the UI.
- Mappers convert between database models and domain models.
- Hilt automatically provides dependencies throughout the application.

---

## 🚀 Progress

With today's work, Codyssey now has a proper persistence architecture.

Current architecture:

```
Compose UI
      │
ViewModel
      │
Repository
      │
Room Repository
      │
DAO
      │
Room
      │
SQLite
```

The application is now structured similarly to production Android projects, making future features such as XP persistence, achievements, streaks, and offline progress much easier to implement.

---

## ⏭️ Next Steps

- Seed the database with initial lesson data.
- Replace the remaining fake lesson source with Room.
- Persist lesson completion across app restarts.
- Introduce asynchronous database operations using coroutines.
