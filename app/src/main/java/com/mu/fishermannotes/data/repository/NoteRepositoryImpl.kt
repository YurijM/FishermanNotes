package com.mu.fishermannotes.data.repository

import com.mu.fishermannotes.data.dao.NoteDao
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
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