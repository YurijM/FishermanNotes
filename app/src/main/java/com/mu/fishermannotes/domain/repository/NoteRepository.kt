package com.mu.fishermannotes.domain.repository

import com.mu.fishermannotes.data.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<NoteEntity>>
    suspend fun insert(note: NoteEntity): Long
}