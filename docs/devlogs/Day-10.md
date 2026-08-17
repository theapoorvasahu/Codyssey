# Day 10

## Objective
Implement app-wide navigation architecture with a single Scaffold, Bottom Navigation, and Navigation Compose.

## Implemented
- Created Screen sealed class for type-safe navigation routes
- Built AppNavHost using Navigation Compose
- Connected all screens using NavHost and composable()
- Implemented Welcome → Home navigation
- Removed Welcome screen from the back stack using popUpTo()
- Created BottomNavItem model
- Built reusable BottomBar component
- Implemented NavigationBar with selected state and icons
- Created MainScreen as the root Scaffold
- Moved Bottom Navigation to the root Scaffold
- Passed PaddingValues from MainScreen → AppNavHost → individual screens
- Removed duplicate Scaffolds from screens
- Replaced TopAppBars with screen titles inside content
- Preserved navigation state using launchSingleTop, restoreState, and saveState
- Hid Bottom Navigation on the Welcome screen
- Successfully tested navigation on a physical Android device

## Learned
- Navigation Compose architecture
- NavHost
- NavController
- Routes and Screen sealed class
- composable()
- navigate()
- popUpTo()
- launchSingleTop
- restoreState
- saveState
- currentBackStackEntryAsState()
- Root Scaffold architecture
- Passing PaddingValues between composables
- Bottom Navigation implementation

## Files
- MainScreen.kt
- AppNavHost.kt
- Screen.kt
- BottomBar.kt
- BottomNavItem.kt
- HomeScreen.kt
- JourneyScreen.kt
- ProjectsScreen.kt
- ProfileScreen.kt
- CodysseyApp.kt

## Next
- Begin Sprint 2: App Architecture
- Learn ViewModel
- Replace hardcoded UI data with state
- Introduce StateFlow and UI State
- Implement MVVM architecture
