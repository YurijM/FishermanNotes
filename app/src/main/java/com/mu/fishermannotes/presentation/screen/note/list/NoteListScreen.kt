package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mu.fishermannotes.R
import com.mu.fishermannotes.presentation.component.FabAdd
import com.mu.fishermannotes.presentation.component.Title
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteDestination
import com.mu.fishermannotes.presentation.utils.NEW_ID

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel(),
    toNote: (NoteDestination) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        OutlinedTextField(
            value = viewModel.search,
            shape = ShapeDefaults.Medium,
            onValueChange = { newValue -> viewModel.onEvent(NoteListEvent.OnNoteSearchChange(newValue)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                errorLeadingIconColor = MaterialTheme.colorScheme.error,
            ),
            label = {
                Text(
                    text = "Поиск",
                )
            },
            singleLine = true,
            leadingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 20.dp, end = 16.dp)
                    )
                    VerticalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .height(dimensionResource(R.dimen.outlined_field_height))
                            .padding(end = 8.dp)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = { viewModel.onEvent(NoteListEvent.OnNoteSearchChange("")) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )
        if (viewModel.notes.isEmpty()) {
            Title(
                title = viewModel.noteListIsEmpty,
                padding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 40.dp
                )
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
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
    }
    FabAdd(onAdd = { toNote(NoteDestination(NEW_ID)) })
}