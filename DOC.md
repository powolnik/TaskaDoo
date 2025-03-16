# TaskAdoo App Documentation

## Overview  
A note-taking app built with Jetpack Compose featuring:  
- Modular navigation system  
- Note creation/management  
- Configurable settings  
- Custom UI components  

---

## Navigation Structure  
**Key Components:**  
- **Screen.kt**: Defines routes (`Home`, `NotesList`, etc.)  
- **NavGraph.kt**: Implements app routing with `Scaffold` and `BottomAppBar`  
- **BottomAppBar.kt**: Provides primary action buttons (Add Note/Settings)  

**Flow:**  
1. Home → Add Note via bottom bar  
2. Notes List ↔ Individual Note Preview  
3. Settings accessible from top app bar  

---

## Core Features  
### Screens  
| Screen | Purpose | Key Components |
|--------|---------|----------------|
| **HomeScreen** | Entry point with bottom navigation | `TDColumn` layout |
| **AddNoteScreen** | Create notes | Title/Content fields + Save button |
| **NotesListScreen** | Manage note list | Search bar, floating action button |
| **SettingsScreen** | Configuration options | Theme selector, sorting controls |

### Data Layer  
- **TDNote**: Note model with `id`, `title`, `content`, date, and color  
- **NotesViewModel**: Manages notes (add/delete/search)  

---

## UI Components  
**Reusable Elements:**  
- `TDButton`: Custom-styled buttons  
- `TDTextField`: Pre-configured text inputs  
- `TDSpacer`: Standardized spacing  
- `TDNoteCard`: Note previews with delete functionality  

**Layouts:**  
- `TDColumn/TDRow`: Simplified layout containers  
- `TDCard`: Material Design 3-styled cards  

---

## Key Features  
1. **Navigation**: Bottom app bar + top bars for screen control  
2. **Notes Management**: Search/filter, deletion via cards  
3. **Settings**: Theme selection, sorting options (Newest/Oldest), sync controls  
4. **UI Consistency**: Custom components ensure style uniformity  

---

## Architecture  
- Jetpack Compose UI layer  
- ViewModel pattern for state management  
- Modular structure: navigation/screens/data layers separated  

---

## TODO Items  
1. Implement note persistence  
2. Add note preview screen  
3. Save settings to storage  
4. Complete cloud sync implementation  
5. Add reminder/notification system  
