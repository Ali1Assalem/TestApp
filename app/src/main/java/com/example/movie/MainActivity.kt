package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.movie.data.db.NotesDatabase
import com.example.movie.reposities.NotesRepo
import com.example.movie.viewmodel.NotesViewModel
import com.example.movie.viewmodel.providerFactory.NotesViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    val viewModel : NotesViewModel by lazy {
        val database = NotesDatabase.getDatabaseInstance(this)
        val noteRepo = NotesRepo(database)
        val noteProviderFactory = NotesViewModelProviderFactory(noteRepo)
        ViewModelProvider(this,noteProviderFactory).get(NotesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}