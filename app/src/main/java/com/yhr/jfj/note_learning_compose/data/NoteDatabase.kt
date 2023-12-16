package com.yhr.jfj.note_learning_compose.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class], // The entities array contains all the data entities (tables) for the database. In this case, it's the Note class.
    version = 1 // This is the version number of the database. It should be incremented whenever the database schema changes.
)
// This class represents the database. It extends RoomDatabase, which is a class provided by the Room persistence library.
abstract class NoteDatabase : RoomDatabase() {
    // This is an abstract property that provides access to the DAO (Data Access Object).
    // The DAO is used to interact with the database.
    abstract val dao: NoteDao
}