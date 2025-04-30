package com.mu.fishermannotes.presentation.screen.note.list

import androidx.lifecycle.ViewModel
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    var notes by mutableStateOf(emptyList<NoteEntity>())

    init {
        viewModelScope.launch {
            noteRepository.getNotes().collect { list ->
                notes = list
            }
        }
    }
}