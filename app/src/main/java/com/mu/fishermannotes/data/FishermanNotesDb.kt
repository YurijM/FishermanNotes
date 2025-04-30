package com.mu.fishermannotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mu.fishermannotes.data.dao.NoteDao
import com.mu.fishermannotes.data.entity.NoteEntity

@Database(
    entities = [
        NoteEntity::class
    ],
    version = 1,
    exportSchema = true
)

abstract class FishermanNotesDb : RoomDatabase() {
    abstract val noteDao: NoteDao
}