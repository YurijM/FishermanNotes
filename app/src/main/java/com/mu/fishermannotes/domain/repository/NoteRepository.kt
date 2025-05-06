package com.mu.fishermannotes.domain.repository

import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<NoteEntity>>
    fun getNote(id: Long): Flow<NoteEntity>
    fun getPhotos(noteId: Long): Flow<List<NotePhotoEntity>>
    fun getMainPhotos(): Flow<List<NotePhotoEntity>>
    suspend fun insertPhoto(photo: NotePhotoEntity): Long
    suspend fun deletePhoto(photo: NotePhotoEntity)
    suspend fun setMainPhoto(noteId: Long, id: Long)
    suspend fun insert(note: NoteEntity): Long
    suspend fun update(note: NoteEntity): Int
}