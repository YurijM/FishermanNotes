package com.mu.fishermannotes.presentation.screen.note

import com.mu.fishermannotes.data.entity.NotePhotoEntity

sealed class NoteEvent {
    data class OnNoteDateChange(val date: Long) : NoteEvent()
    data class OnNoteTemperatureChange(val temperature: String) : NoteEvent()
    data class OnNoteWingChange(val wing: String) : NoteEvent()
    data class OnNotePressureChange(val pressure: String) : NoteEvent()
    data class OnNoteMoonChange(val moon: String) : NoteEvent()
    data class OnNoteLocationChange(val location: String) : NoteEvent()
    data class OnNoteNoteChange(val note: String) : NoteEvent()
    data class OnNotePhotoSave(val photo: NotePhotoEntity) : NoteEvent()
    data class OnNotePhotoDelete(val photo: NotePhotoEntity) : NoteEvent()
    data class OnNoteSetMainPhoto(val noteId: Long, val id: Long) : NoteEvent()
    data object OnNoteSave : NoteEvent()
}