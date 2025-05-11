package com.mu.fishermannotes.presentation.screen.note.list

import com.mu.fishermannotes.data.entity.NoteEntity

sealed class NoteListEvent {
    data class OnNoteDelete(val note: NoteEntity) : NoteListEvent()
}