# Day 23 — Room, Coroutines & Database Seeding

## 📅 Date
15 September 2026

---

## 🎯 Goal

Transition Codyssey from an in-memory fake repository to a persistent Room database while learning asynchronous database operations using Kotlin Coroutines.

---

## ✅ What I Built

- Converted all DAO operations to `suspend` functions.
- Updated the Repository interface and implementations to support coroutines.
- Migrated the ViewModel to use `viewModelScope.launch` for asynchronous data loading.
- Replaced the Fake Repository with `RoomLessonRepository` using Hilt dependency injection.
- Implemented automatic database seeding on first launch.
- Created a dedicated `SeedData` object as the single source of truth for initial lessons.
- Added bulk insertion support using `insertLessons()`.
- Prevented duplicate seed data using `OnConflictStrategy.IGNORE`.
- Added a lightweight `getLessonCount()` query to detect an empty database.
- Verified that lesson completion is now persisted across app restarts using SQLite.

---

## 📚 Key Concepts Learned

### Kotlin Coroutines
- `suspend` functions
- Why database operations should never block the Main Thread
- `viewModelScope.launch`
- Asynchronous execution in MVVM

### Room
- Suspend DAO methods
- Bulk inserts
- Conflict strategies
- Database seeding
- Persistent local storage

### Architecture
- Repository owns all data-related logic
- ViewModel should not know how data is fetched or initialized
- Separation of concerns
- Encapsulation of database initialization

---

## 🧠 Biggest Learnings

- `suspend` marks operations that may take time and must execute inside a coroutine.
- The Repository should hide implementation details such as database seeding from the ViewModel.
- Seeding should happen automatically when the database is empty rather than being triggered manually.
- Room persists data between app launches, unlike an in-memory repository.
- Designing the data model correctly is just as important as implementing the architecture.

---

## ⚠️ Challenges Faced

- Learned why suspend functions cannot be called directly from the ViewModel.
- Understood how coroutine scopes solve asynchronous database access.
- Realized that storing only a `completed: Boolean` is insufficient for representing the three lesson states:
  - Locked
  - Current
  - Completed
- Identified this as a schema design limitation rather than an implementation bug.

---

## 🚀 Current Architecture

```text
Compose UI
      │
      ▼
LessonViewModel
      │
      ▼
LessonRepository
      │
      ▼
RoomLessonRepository
      │
      ├──────────────┐
      ▼              │
seedDatabaseIfNeeded │
      │              │
      ▼              │
LessonDao            │
      │              │
      ▼              │
SQLite Database      │
                     │
SeedData ────────────┘
```

---

## 📈 Progress

- Room Database ✅
- Hilt Dependency Injection ✅
- Repository Pattern ✅
- Coroutines ✅
- ViewModelScope ✅
- Database Seeding ✅
- SQLite Persistence ✅

---

## 🔜 Next Steps

- Redesign the Room schema to support full lesson progression.
- Replace the temporary `completed` boolean with a proper lesson state representation.
- Restore Locked → Current → Completed progression.
- Continue building Sprint 3.

---

## 💭 Reflection

Today marked the transition from an app powered by hardcoded data to one backed by a real persistent database. More importantly, I learned why asynchronous programming is essential in Android and how Room, Coroutines, Hilt, and MVVM work together to build scalable, production-ready applications.
