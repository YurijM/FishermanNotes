package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    var notes by mutableStateOf(emptyList<NoteEntity>())
    var photos by mutableStateOf(emptyList<NotePhotoEntity>())

    init {
        viewModelScope.launch {
            noteRepository.getNotes().collect { list ->
                notes = list.sortedByDescending { it.date }
            }
        }
        viewModelScope.launch {
            noteRepository.getMainPhotos().collect { list ->
                photos = list.sortedBy { it.noteId }
            }
        }
    }
}