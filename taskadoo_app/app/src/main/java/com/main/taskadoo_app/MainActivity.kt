package com.main.taskadoo_app

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.main.taskadoo_app.src.Note
import com.main.taskadoo_app.src.NoteComposable
import com.main.taskadoo_app.src.NotesListComposable
import com.main.taskadoo_app.ui.theme.ComposeTestTheme

//region MainActivity
    // Main activity class that sets up the application content
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                ComposeTestTheme {
                    NotesListComposable(notes = listOf(Note("Note 1", "This is note 1"), Note("Note 2", "This is note 2")))
                }
            }
        }
    }
//endregion
@Preview(showBackground = true)
@Composable
fun MainActivityPreview(){
    MainActivity()
}
/*
//region Composable
    // Composable function that displays styled text
    @Composable
    fun FText(color: Color = MaterialTheme.colorScheme.error, inputText: String = "DEFAULT") {
        if (inputText.isEmpty()) {
            // Error handling for empty input text
            throw IllegalArgumentException("Input text cannot be empty")
        }
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(textAlign = TextAlign.Center,)) {
                    withStyle(style = SpanStyle(
                        color = color,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold)
                    ) {
                        append("$inputText")
                    }
                }
            }
        )
    }

    // FButton uses FText to display a title
    // Composable function that creates a button within the column scope
    // FColumns uses FSurface to create a surface within a column scope
    // Composable function that creates a column layout with two surfaces
    @Composable
    fun FColumns() {
        // Remove unnecessary variable assignment
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(500.dp) // Removed redundant height assignment
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            FSurface(MaterialTheme.colorScheme.primaryContainer)
            FSurface(MaterialTheme.colorScheme.surfaceVariant)
            //for
        }
    }

    // FSurface uses FButton to create a button within a surface scope
    // Composable function that creates a surface within a column scope
    @Composable
    fun ColumnScope.FSurface(color: Color = MaterialTheme.colorScheme.primary, weight: Float = 1f) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(weight)
                .wrapContentHeight(Alignment.CenterVertically),
            color = color
        ) {
            FButton("Button")
        }
    }
    @Composable
    fun FButton(text: String = "DEFAULT EXCEPTIION TEXT") {
        if (text.isEmpty()) {
            // Error handling for empty button text
            throw IllegalArgumentException("Button text cannot be empty")
        }
        FText(MaterialTheme.colorScheme.onPrimary, text)
    }
//endregion

//region Composable Preview
    // Preview composable function that displays the FColumns composable
    @Preview(showBackground = true)
    @Composable
    fun FColumnsPreview() {
        ComposeTestTheme {
            FColumns()
        }
    }
//endregion*/
/*
// MainActivity.kt
package com.example.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// Data class for Note
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

// Data Access Object (DAO) for Note
@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?
}

// Database
@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: ComponentActivity): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

// Repository
class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

    suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }
}

// ViewModel
class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val allNotes: Flow<List<Note>> = repository.allNotes

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    suspend fun getNoteById(id: Int): Note? {
        return repository.getNoteById(id)
    }
}

// ViewModel Factory
class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

// Screens
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(
    navController: NavController,
    viewModel: NoteViewModel
) {
    val notes by viewModel.allNotes.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("editNote/0") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Note",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    onNoteClick = { navController.navigate("editNote/${note.id}") },
                    onDeleteClick = {
                        scope.launch {
                            viewModel.delete(note)
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteItem(
    note: Note,
    onNoteClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNoteClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Note"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteScreen(
    navController: NavController,
    noteId: Int,
    viewModel: NoteViewModel
) {
    var note by remember { mutableStateOf(Note(0, "", "")) }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    // Load existing note if editing
    LaunchedEffect(noteId) {
        if (noteId != 0) {
            viewModel.getNoteById(noteId)?.let {
                note = it
                title = it.title
                content = it.content
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (noteId == 0) "New Note" else "Edit Note") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.Add, // Replace with back icon
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (title.isNotBlank()) {
                        scope.launch {
                            if (noteId == 0) {
                                viewModel.insert(Note(title = title, content = content))
                            } else {
                                viewModel.update(note.copy(title = title, content = content))
                            }
                            navController.popBackStack()
                        }
                    }
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add, // Replace with save icon
                    contentDescription = "Save Note",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                minLines = 10
            )
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = NoteDatabase.getDatabase(this)
        val repository = NoteRepository(database.noteDao())
        val factory = NoteViewModelFactory(repository)

        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val noteViewModel: NoteViewModel = viewModel(factory = factory)

                NavHost(navController = navController, startDestination = "noteList") {
                    composable("noteList") {
                        NoteListScreen(navController, noteViewModel)
                    }
                    composable("editNote/{noteId}") { backStackEntry ->
                        val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull() ?: 0
                        EditNoteScreen(navController, noteId, noteViewModel)
                    }
                }
            }
        }
    }
}
*/