package com.mu.fishermannotes.presentation.screen.note.list

import com.mu.fishermannotes.data.entity.NoteEntity

sealed class NoteListEvent {
    data class OnNoteSearchChange(val search: String) : NoteListEvent()
    data object OnNoteSearchStart : NoteListEvent()
    data class OnNoteDelete(val note: NoteEntity) : NoteListEvent()
}