# Quest Room Persistence

## Overview

This milestone extends Codyssey's persistence layer by introducing Room support for Quests.

Previously, lessons were persisted locally while quests were still backed by static data. This update moves quest data into Room, allowing quests to be seeded, queried, updated, and unlocked through a dedicated repository.

The project now follows a consistent architecture for both Lessons and Quests.

---

## What was implemented

### QuestEntity

Created a Room entity representing quests.

Fields include:

- id
- title
- description
- xpReward
- unlocked
- completed

---

### QuestDao

Added DAO methods for:

- Fetch all quests
- Fetch quest by ID
- Insert seed data
- Update quests
- Count existing quests

This mirrors the structure already established for LessonDao.

---

### RoomQuestRepository

Implemented a Room-backed QuestRepository.

Responsibilities:

- Seed the database on first launch
- Return mapped domain models
- Unlock quests
- Persist quest updates

This replaces the previous fake repository for production data.

---

### Database updates

Expanded CodysseyDatabase to include:

- QuestEntity
- QuestDao

Database version was incremented to trigger migration during development.

---

### Dependency Injection

Updated Hilt configuration to provide:

- QuestDao
- QuestRepository

LessonRepository can now depend on QuestRepository, enabling lesson completion to unlock future quests without directly accessing Room.

This keeps repositories loosely coupled.

---

### Project Structure

Reorganized the data layer into feature-specific packages:

```
data/
    lesson/
    quest/
    profile/
    local/
```

The persistence layer is now significantly cleaner and easier to scale.

---

## Architecture

Current flow:

```
UI
 ↓
ViewModel
 ↓
Repository
 ↓
Room DAO
 ↓
SQLite
```

Lessons and Quests now follow the exact same architecture.

---

## Current Status

✅ Lesson persistence

✅ Quest persistence

✅ User profile persistence

✅ Room database

✅ Repository pattern

✅ Hilt dependency injection

---

## Next milestone

The next objective is to connect lesson completion with quest progression.

When every lesson belonging to a quest is completed:

- mark the quest as completed
- unlock the next quest
- update the Home and Journey screens automatically

This will complete the first version of Codyssey's progression system.
