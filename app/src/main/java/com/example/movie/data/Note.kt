package com.example.movie.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val noteId:Int = 0,

    val noteTite:String,
    val noteText:String,
    //val data:Date

):Parcelable
