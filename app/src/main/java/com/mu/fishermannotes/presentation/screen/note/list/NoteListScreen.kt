package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mu.fishermannotes.presentation.component.FabAdd
import com.mu.fishermannotes.presentation.component.Title
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteDestination
import com.mu.fishermannotes.presentation.utils.NEW_ID

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel(),
    toNote: (NoteDestination) -> Unit
) {
    if (viewModel.notes.isEmpty()) {
        Title(
            title = "Ни одна заметка ещё не добавлена",
            padding = PaddingValues(
                horizontal = 16.dp,
                vertical = 40.dp
            )
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
        ) {
            items(viewModel.notes) { note ->
                val photo = viewModel.photos.find { it.noteId == note.id }
                NoteListItemScreen(
                    note,
                    photo,
                    onEdit = { toNote(NoteDestination(note.id)) },
                    onDelete = { viewModel.onEvent(NoteListEvent.OnNoteDelete(note)) },
                )
            }
        }
    }
    FabAdd(onAdd = { toNote(NoteDestination(NEW_ID)) })
}