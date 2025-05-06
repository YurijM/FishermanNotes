package com.mu.fishermannotes.data.repository

import com.mu.fishermannotes.data.dao.NoteDao
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getMainPhotos(): Flow<List<NotePhotoEntity>> {
        return dao.getMainPhotos()
    }

    override fun getPhotos(noteId: Long): Flow<List<NotePhotoEntity>> {
        return dao.getPhotos(noteId)
    }

    override suspend fun deletePhoto(photo: NotePhotoEntity) {
        dao.deletePhoto(photo)
    }

    override suspend fun setMainPhoto(noteId: Long, id: Long) {
        dao.setMainPhoto(noteId, id)
    }

    override suspend fun update(note: NoteEntity): Int {
        return dao.update(note)
    }

    override suspend fun insertPhoto(photo: NotePhotoEntity): Long {
        return dao.insertPhoto(photo)
    }

    override fun getNotes(): Flow<List<NoteEntity>> {
        return dao.getNotes()
    }

    override fun getNote(id: Long): Flow<NoteEntity> {
        return dao.getNote(id)
    }

    override suspend fun insert(note: NoteEntity): Long {
        return dao.insert(note)
    }
}