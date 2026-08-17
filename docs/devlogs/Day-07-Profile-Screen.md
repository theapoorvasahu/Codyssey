# Day 7

## Objective
Build the dynamic Journey roadmap with reusable roadmap nodes and curved Canvas connectors.

## Implemented
- Created Lesson and LessonState models
- Built reusable RoadmapNode component
- Implemented custom HexagonShape
- Created JourneyPath composable
- Drew smooth cubic Bézier connectors between lessons
- Dynamically tracked node positions using onGloballyPositioned()
- Connected nodes using Canvas and Path
- Refactored connector calculations into createConnectorPath()
- Added dashed connector styling
- Added rounded stroke caps and joins
- Refined connector curvature and trimming based on node radius

## Learned
- Cubic Bézier curves
- cubicTo()
- onGloballyPositioned()
- positionInRoot()
- MutableStateList
- PathEffect.dashPathEffect()
- StrokeCap
- StrokeJoin
- Custom Shape in Jetpack Compose
- Canvas architecture for dynamic UI

## Files
- JourneyScreen.kt
- JourneyPath.kt
- RoadmapNode.kt
- HexagonShape.kt
- Lesson.kt
- LessonState.kt

## Next
- Animate roadmap nodes
- Differentiate locked/completed connectors
- Build Profile screen
- Build Projects screen
- Add navigation between screens
