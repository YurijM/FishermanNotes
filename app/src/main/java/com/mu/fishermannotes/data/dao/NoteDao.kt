package com.mu.fishermannotes.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM table_notes")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM table_notes " +
            "WHERE id = :id")
    fun getNote(id: Long): Flow<NoteEntity>

    @Query("SELECT * FROM table_photos " +
            "WHERE is_main = 1")
    fun getMainPhotos(): Flow<List<NotePhotoEntity>>

    @Query("SELECT * FROM table_photos " +
            "WHERE note_id = :noteId")
    fun getPhotos(noteId: Long): Flow<List<NotePhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhoto(photo: NotePhotoEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(note: NoteEntity): Long
}