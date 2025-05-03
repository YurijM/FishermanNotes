package com.mu.fishermannotes.presentation.screen.note

sealed class NoteEvent {
    data class OnNoteDateChange(val date: Long) : NoteEvent()
}