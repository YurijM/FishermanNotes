package com.mu.fishermannotes.presentation.screen.note

sealed class NoteEvent {
    data class OnNoteDateChange(val date: Long) : NoteEvent()
    data class OnNoteTemperatureChange(val temperature: String) : NoteEvent()
    data class OnNoteWingChange(val wing: String) : NoteEvent()
    data class OnNotePressureChange(val pressure: String) : NoteEvent()
    data class OnNoteMoonChange(val moon: String) : NoteEvent()
    data class OnNoteNoteChange(val note: String) : NoteEvent()
    data object OnNoteSave : NoteEvent()
}