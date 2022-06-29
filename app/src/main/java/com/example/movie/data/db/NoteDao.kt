package com.example.movie.data.db

import androidx.room.*
import com.example.movie.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY noteId DESC")
    fun selectNote():Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE noteTite LIKE '%' ||:searchQuery|| '%' ")
    fun searchNoteTitle(searchQuery : String):  Flow<List<Note>>

    @Query("DELETE From Note")
    suspend fun deleteAllNotes()

}