package com.mu.fishermannotes.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
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
            "WHERE note_id = :noteId " +
            "ORDER BY is_main DESC")
    fun getPhotos(noteId: Long): Flow<List<NotePhotoEntity>>

    @Query("UPDATE table_photos " +
            "SET is_main = 0 " +
            "WHERE note_id = :noteId")
    suspend fun clearMainPhoto(noteId: Long)

    @Query("UPDATE table_photos " +
            "SET is_main = 1 " +
            "WHERE id = :id")
    suspend fun updateMainPhoto(id: Long)

    @Transaction
    suspend fun setMainPhoto(noteId: Long, id: Long) {
        clearMainPhoto(noteId)
        updateMainPhoto(id)
    }

    @Query("DELETE FROM table_photos " +
            "WHERE note_id = :noteId")
    suspend fun deleteNotePhotos(noteId: Long)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhoto(photo: NotePhotoEntity): Long

    @Delete
    suspend fun deletePhoto(photo: NotePhotoEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteEntity): Long

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(note: NoteEntity): Int

    @Delete
    suspend fun delete(note: NoteEntity)

    @Transaction
    suspend fun deleteNote(note: NoteEntity) {
        deleteNotePhotos(note.id)
        delete(note)
    }

}