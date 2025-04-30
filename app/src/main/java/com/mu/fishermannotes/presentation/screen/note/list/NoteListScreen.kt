package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mu.fishermannotes.presentation.component.Title

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel()
) {
    if (viewModel.notes.isEmpty()) {
        Title(
            title = "Ни одна заметка ещё не добавлена",
            paddingValues = PaddingValues(
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
                Text(note.photoPath)
            }
        }
    }
}