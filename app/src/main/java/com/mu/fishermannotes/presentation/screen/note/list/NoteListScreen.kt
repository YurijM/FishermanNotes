package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel()
) {
    Text("Заметки")
}