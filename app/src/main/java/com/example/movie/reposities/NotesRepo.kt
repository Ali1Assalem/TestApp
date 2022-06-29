package com.example.movie.reposities

import com.example.movie.data.Note
import com.example.movie.data.db.NotesDatabase

class NotesRepo (
    notesDatabase:NotesDatabase
) {
    val notesDao = notesDatabase.noteDao

    suspend fun upsertNote(note:Note)=notesDao.upsertNote(note)

    suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)

    fun getNotes() = notesDao.selectNote()

    fun searchNotes(searchQuery:String) = notesDao.searchNoteTitle(searchQuery)

    suspend fun deleteAllNotes() = notesDao.deleteAllNotes()

}