package com.example.movie.viewmodel.providerFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.reposities.NotesRepo
import com.example.movie.viewmodel.NotesViewModel

class NotesViewModelProviderFactory (
    private val notesRepo:NotesRepo

    ):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         return NotesViewModel(notesRepo) as T
    }

}