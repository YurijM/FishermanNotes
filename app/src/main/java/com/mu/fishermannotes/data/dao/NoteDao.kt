package com.mu.fishermannotes.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.data.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM table_notes")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM table_notes " +
            "WHERE id = :id")
    fun getNote(id: Long): Flow<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(draw: NoteEntity): Long
}