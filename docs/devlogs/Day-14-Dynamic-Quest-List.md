# Day 14 – Dynamic Quest List with LazyColumn

## Goal

Replace the single hardcoded quest with a dynamic list of quests loaded from the repository.

---

## What I Learned

- Difference between `Column` and `LazyColumn`
- Why `LazyColumn` only composes visible items
- `LazyListScope`
- `item {}` vs `items()`
- Displaying a list of models in Compose
- Connecting Repository → ViewModel → UI

---

## What I Built

- Updated `HomeUiState` to store a `List<Quest>`
- Updated `HomeViewModel` to load all quests from `FakeQuestRepository`
- Replaced the single `QuestCard` with a dynamic `items()` block
- Added multiple quests to the repository
- Progress remains capped at 100%
- Quest list now renders automatically from data

---

## Challenges

Initially, I placed `items()` inside an `item {}` block, which caused compilation errors.

I learned that `item {}` and `items()` are siblings inside `LazyColumn` because both belong to the `LazyListScope` DSL.

---

## Key Takeaway

Instead of manually creating each `QuestCard`, Compose can generate the UI for an entire list from a collection of data.

This makes the UI scalable and keeps it synchronized with the data layer.

---

## Next Steps

- Handle actions for individual quests
- Improve quest completion logic
- Continue making the Home screen fully data-driven
