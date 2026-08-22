# Day 13 — Quest Model & Repository

## Goal

Refactor the Home screen to use a proper Quest model instead of hardcoded strings.

---

## What I Built

- Created a `Quest` data model.
- Added a `FakeQuestRepository`.
- Moved quest data out of the ViewModel.
- Updated `HomeUiState` to hold a `Quest` object.
- Refactored `HomeViewModel` to fetch the current quest from the repository.
- Updated `HomeScreen` to consume the `Quest` model.
- Fixed the progress bug by keeping XP and roadmap progress as separate concepts.

---

## Concepts Learned

- Domain Models
- Repository Pattern
- Fake Data Source
- UI State Refactoring
- Nullable Objects
- Model-driven UI

---

## Biggest Takeaway

Instead of storing individual properties like:

- questTitle
- questDescription

the UI now receives an entire `Quest` object.

This makes the code easier to extend and much closer to production architecture.

---

## Architecture

FakeQuestRepository
        │
        ▼
      Quest
        │
        ▼
 HomeViewModel
        │
        ▼
 HomeUiState
        │
        ▼
 HomeScreen

---

## Challenges Faced

While refactoring, I accidentally used XP as the roadmap progress again, causing the progress bar to exceed 100%.

The fix was to keep XP and roadmap progress as separate pieces of state.

---

## Next

Replace the single quest with a list of quests and make the Home screen behave more like a real learning dashboard.
