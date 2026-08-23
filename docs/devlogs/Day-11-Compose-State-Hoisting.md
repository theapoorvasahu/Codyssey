# Day 11 — Compose State & ViewModel

## Goal

Learn how state is managed in Jetpack Compose and understand why ViewModels exist.

---

## What I Built

- Created a Compose playground
- Managed UI state using `remember { mutableStateOf() }`
- Updated UI through recomposition
- Practiced state hoisting
- Created a `PlaygroundUiState` data class
- Moved business logic into `PlaygroundViewModel`
- Connected the UI with the ViewModel using `viewModel()`
- Kept the UI stateless by passing data and callbacks

---

## Concepts Learned

- State
- Mutable State
- Recomposition
- State Hoisting
- Stateless vs Stateful Composables
- ViewModel
- Immutable UI State
- `copy()` on data classes

---

## Biggest Takeaway

A composable should describe the UI, not own the business logic.

The ViewModel owns the state.

The UI simply displays it and sends user actions back to the ViewModel.

---

## Architecture

```
Button Click
      │
      ▼
LayoutPlayground
      │
      ▼
PlaygroundScreen
      │
      ▼
PlaygroundViewModel
      │
      ▼
PlaygroundUiState
      │
      ▼
UI Recomposition
```

---

## Next

Sprint 2 officially begins.

Build the Home screen using proper state management instead of static data.
