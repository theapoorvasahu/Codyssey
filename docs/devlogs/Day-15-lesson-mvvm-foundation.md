# Day 15 – Lesson MVVM Foundation

## Goal

Start migrating the Journey feature to the MVVM architecture by introducing a dedicated Lesson data layer.

---

## What I Built

- Created the `Lesson` model with lesson metadata.
- Created `FakeLessonRepository` to store lesson data.
- Added `LessonUiState` to represent the UI state of the lesson feature.
- Added `LessonViewModel` to expose lesson data to the UI.
- Updated the Journey screen to consume lesson data from the repository instead of using a hardcoded list.
- Restored lesson states (Completed, Current, Locked) after expanding the Lesson model.

---

## What I Learned

- MVVM architecture is reusable across multiple features.
- A Repository acts as the single source of truth for feature data.
- ViewModels expose immutable UI state instead of allowing screens to own data.
- Every model change affects all code that constructs that model.
- Separating data from UI makes the app easier to scale.

---

## Challenges

Initially, changing the `Lesson` model caused multiple compilation errors because existing code still used the old constructor. After updating the repository and restoring the lesson state, the project compiled successfully.

---

## Outcome

The Journey feature now has its own MVVM foundation, making it ready for future features like lesson completion, unlocking lessons, XP updates, and persistent progress.
