# Day 12 — First MVVM Screen

## Goal

Transform the Home screen from a static UI into a dynamic screen powered by a ViewModel.

---

## What I Built

- Created `HomeUiState`
- Created `HomeViewModel`
- Connected `HomeScreen` to the ViewModel
- Replaced hardcoded values with UI state
- Updated the UI through state changes
- Implemented quest completion logic
- Separated XP from roadmap progress
- Fixed progress overflow by capping it at 100%

---

## Concepts Learned

- MVVM Architecture
- UI State
- ViewModel
- Immutable State
- `copy()`
- State-driven UI
- Recomposition
- Single Source of Truth

---

## Biggest Takeaway

The UI should never own data.

Instead:

```
ViewModel
      ↓
UI State
      ↓
Composable UI
```

Whenever the state changes, Compose automatically recomposes the affected UI.

---

## Challenges Faced

Initially, I used XP as the roadmap progress.

This caused the progress indicator to exceed 100%.

I realized XP and roadmap progress represent different concepts, so I separated them into independent fields in the UI state.

---

## Architecture

```
HomeScreen
      │
      ▼
HomeViewModel
      │
      ▼
HomeUiState
      │
      ▼
ProgressSummaryCard
QuestCard
```

---

## Next

Continue Sprint 2 by making the Home screen feel like a real learning dashboard with better quest management and dynamic data.
