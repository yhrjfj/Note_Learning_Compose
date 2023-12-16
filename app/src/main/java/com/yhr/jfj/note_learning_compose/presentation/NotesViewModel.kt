package com.yhr.jfj.note_learning_compose.presentation

import androidx.lifecycle.ViewModel
import com.yhr.jfj.note_learning_compose.data.NoteDao

class NotesViewModel(
    private val dao: NoteDao
) : ViewModel() {
}