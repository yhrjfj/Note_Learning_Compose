package com.yhr.jfj.note_learning_compose.presentation

import com.yhr.jfj.note_learning_compose.data.Note

sealed interface NotesEvent {
    data object SortNotes : NotesEvent

    data class DeleteNote(val note: Note) : NotesEvent

    data class SaveNote(val title: String, val description: String) : NotesEvent
}