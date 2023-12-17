package com.yhr.jfj.note_learning_compose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yhr.jfj.note_learning_compose.data.NoteDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val dao: NoteDao
) : ViewModel() {
    private var isShortedByDateAdded = MutableStateFlow(true)

    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    dao.deleteNote(event.note)
                }
            }
            is NotesEvent.SaveNote -> {
                // TODO: Start from here: https://youtu.be/5pjdE2wnJ0s?si=POKjHxMISf8mo8qS&t=1311
            }
            NotesEvent.SortNotes -> {
                isShortedByDateAdded.value = !isShortedByDateAdded.value
            }
        }
    }
}