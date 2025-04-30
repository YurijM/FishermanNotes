package com.mu.fishermannotes.presentation.screen.note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    var note by mutableStateOf(NoteEntity())

    init {

    }
}