package com.yhr.jfj.note_learning_compose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    // The @Upsert annotation is a convenience for updating or inserting a note.
    // If the note already exists in the database, it will be updated.
    // If the note does not exist, it will be inserted.
    @Upsert
    suspend fun upsertNote(note: Note)

    // The @Delete annotation is used to delete a specific note from the database.
    // The note object passed as a parameter should match a note in the database.
    @Delete
    suspend fun deleteNote(note: Note)

    // This function retrieves all notes from the database and orders them by the date they were added.
    // The @Query annotation defines the SQL query to be executed.
    // The function returns a Flow, which is a stream of data that can be collected asynchronously.
    @Query("SELECT * FROM note ORDER BY dateAdded")
    fun getNoteOrderedByNoteAdded(): Flow<List<Note>>

    // This function retrieves all notes from the database and orders them by their title.
    // The @Query annotation defines the SQL query to be executed.
    // The function returns a Flow, which is a stream of data that can be collected asynchronously.
    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getNoteOrderedByTitle(): Flow<List<Note>>
}