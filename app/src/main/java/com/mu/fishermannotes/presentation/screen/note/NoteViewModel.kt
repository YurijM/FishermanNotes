package com.mu.fishermannotes.presentation.screen.note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteDestination
import com.mu.fishermannotes.presentation.utils.NEW_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    savedStateHandle: SavedStateHandle,
    ) : ViewModel() {
    var note by mutableStateOf(NoteEntity())
    var exit by mutableStateOf(false)
        private set

    init {
        val id = savedStateHandle.toRoute<NoteDestination>().id

        if (id == NEW_ID) {
            note = NoteEntity(
                date = Calendar.getInstance().timeInMillis
            )
        } else {
            viewModelScope.launch {
                noteRepository.getNote(id).collect { item ->
                    note = item
                }
            }
        }
    }

    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.OnNoteDateChange -> {
                note = note.copy(date = event.date)
            }
            is NoteEvent.OnNoteTemperatureChange -> {
                note = note.copy(temperature = event.temperature)
            }
            is NoteEvent.OnNoteWingChange -> {
                note = note.copy(wing = event.wing)
            }
            is NoteEvent.OnNotePressureChange -> {
                note = note.copy(pressure = event.pressure)
            }
            is NoteEvent.OnNoteMoonChange -> {
                note = note.copy(moon = event.moon)
            }
            is NoteEvent.OnNoteNoteChange -> {
                note = note.copy(note = event.note)
            }
            is NoteEvent.OnNoteSave -> {
                exit = true
            }
        }
    }
}