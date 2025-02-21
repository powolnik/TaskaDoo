package com.example.notesapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.main.taskadooapp.databinding.ActivityMainBinding // Corrected import

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val notesList = mutableListOf<String>()
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView with a linear layout manager and the adapter
        adapter = NoteAdapter(notesList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this) // Corrected line
        binding.recyclerView.adapter = adapter

        // FAB opens a dialog to add a new note
        binding.fab.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun showAddNoteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add Note")

        val input = EditText(this)
        input.hint = "Enter note here"
        builder.setView(input)

        builder.setPositiveButton("Save") { dialog, _ ->
            val noteText = input.text.toString()
            if (noteText.isNotBlank()) {
                notesList.add(noteText)
                adapter.notifyItemInserted(notesList.size - 1)
            }
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}