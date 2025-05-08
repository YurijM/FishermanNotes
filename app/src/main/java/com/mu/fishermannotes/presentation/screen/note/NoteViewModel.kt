package com.mu.fishermannotes.presentation.screen.note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.domain.repository.NoteRepository
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteDestination
import com.mu.fishermannotes.presentation.utils.NEW_ID
import com.mu.fishermannotes.presentation.utils.toLog
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
    var photos by mutableStateOf(emptyList<NotePhotoEntity>())
    var noteId by mutableLongStateOf(0L)
        private set
    var newNote by mutableStateOf(false)
        private set
    var exit by mutableStateOf(false)
        private set

    init {
        noteId = savedStateHandle.toRoute<NoteDestination>().id
        toLog("start -> noteId: $noteId")
        newNote = noteId == NEW_ID

        if (newNote) {
            note = NoteEntity(
                date = Calendar.getInstance().timeInMillis
            )
        } else {
            viewModelScope.launch {
                noteRepository.getNote(noteId).collect { item ->
                    note = item
                }
            }
            viewModelScope.launch {
                toLog("getPhotos -> noteId -> before: $noteId")
                //noteRepository.getPhotos(noteId).first()
                noteRepository.getPhotos(noteId).collect { list ->
                    photos = list
                    toLog("getPhotos -> noteId -> after: $noteId")
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

            is NoteEvent.OnNotePhotoSave -> {
                viewModelScope.launch {
                    noteRepository.insertPhoto(event.photo)

                    if (newNote) {
                        photos = photos.toMutableList() + event.photo
                        toLog("OnNotePhotoSave -> photos: $photos")
                    }
                }
            }

            is NoteEvent.OnNotePhotoDelete -> {
                viewModelScope.launch {
                    noteRepository.deletePhoto(event.photo)
                }
            }

            is NoteEvent.OnNoteSetMainPhoto -> {
                viewModelScope.launch {
                    noteRepository.setMainPhoto(event.noteId, event.id)
                }
            }

            is NoteEvent.OnNoteSave -> {
                if (noteId == NEW_ID) {
                    viewModelScope.launch {
                        noteId = noteRepository.insert(note)
                        note = note.copy(id = noteId)
                    }
                } else {
                    exit = true
                    viewModelScope.launch {
                        noteRepository.update(note)
                    }
                }
            }
        }
    }
}
