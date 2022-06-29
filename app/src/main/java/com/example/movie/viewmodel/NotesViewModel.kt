package com.example.movie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.data.Note
import com.example.movie.reposities.NotesRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NotesViewModel(private val notesRepo: NotesRepo)
    : ViewModel(){

    private val _searchNotes = MutableStateFlow<List<Note>>(emptyList())
    val searchNote:StateFlow<List<Note>> = _searchNotes

    val notes = notesRepo.getNotes()

    fun upsertNote(note:Note) = viewModelScope.launch {
        notesRepo.upsertNote(note)
    }

    fun deleteNote(note:Note) = viewModelScope.launch {
        notesRepo.deleteNote(note)
    }

    fun deleteAllNotes() = viewModelScope.launch {
        notesRepo.deleteAllNotes()
    }

    fun searchNotes(searchQuery:String) = viewModelScope.launch {
        notesRepo.searchNotes(searchQuery).collect { notesList ->
            _searchNotes.emit(notesList)
        }
    }

}