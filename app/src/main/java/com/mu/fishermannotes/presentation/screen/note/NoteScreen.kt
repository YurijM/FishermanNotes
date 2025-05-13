package com.mu.fishermannotes.presentation.screen.note

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.mu.fishermannotes.R
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.presentation.component.DialogText
import com.mu.fishermannotes.presentation.component.OkAndCancel
import com.mu.fishermannotes.presentation.component.OutlinedTextEdit
import com.mu.fishermannotes.presentation.component.SetDate
import com.mu.fishermannotes.presentation.component.Title
import com.mu.fishermannotes.presentation.component.DropDownList
import com.mu.fishermannotes.presentation.navigation.Destinations.PhotoDestination
import com.mu.fishermannotes.presentation.utils.DELETE
import com.mu.fishermannotes.presentation.utils.MAIN
import com.mu.fishermannotes.presentation.utils.MOON
import com.mu.fishermannotes.presentation.utils.NEW_ID
import com.mu.fishermannotes.presentation.utils.PHOTO_MENU_ITEM
import com.mu.fishermannotes.presentation.utils.VIEW
import com.mu.fishermannotes.presentation.utils.WINGS
import com.mu.fishermannotes.presentation.utils.asDate
import com.mu.fishermannotes.presentation.utils.toLog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    toNoteList: () -> Unit,
    toPhoto: (PhotoDestination) -> Unit,
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    var openDialogNewNote by remember { mutableStateOf(false) }
    var openDialogDeletePhoto by remember { mutableStateOf(false) }
    var selectedPhoto by remember { mutableStateOf(NotePhotoEntity()) }

    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            imageUri = uri

            context.contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)

            viewModel.onEvent(
                NoteEvent.OnNotePhotoSave(
                    NotePhotoEntity(
                        noteId = viewModel.note.id,
                        photoPath = imageUri.toString(),
                        isMain = viewModel.photos.isEmpty()
                    )
                )
            )
        }
    }

    LaunchedEffect(key1 = viewModel.note, key2 = viewModel.exit) {
        datePickerState.selectedDateMillis = viewModel.note.date

        toLog("Screen -> LaunchedEffect")
        if (viewModel.newNote && viewModel.noteId != NEW_ID && viewModel.photos.isEmpty()) {
            launcher.launch("image/*")
        }

        if (viewModel.exit) toNoteList()
    }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Title(
                title = "Заметка",
                padding = PaddingValues(top = 0.dp)
            )
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(top = 4.dp)
            )
            ShowDate(
                date = viewModel.note.date,
                onClick = { showDatePicker = true }
            )
            OutlinedTextEdit(
                value = viewModel.note.location,
                label = stringResource(R.string.location),
                onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNoteLocationChange(newValue)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                height = 48.dp,
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                SetParameter(
                    value = viewModel.note.temperature,
                    label = stringResource(R.string.temperature),
                    keyboardType = KeyboardType.Password,
                    onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNoteTemperatureChange(newValue)) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                SetParameter(
                    value = viewModel.note.pressure,
                    label = stringResource(R.string.pressure),
                    keyboardType = KeyboardType.NumberPassword,
                    onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNotePressureChange(newValue)) }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                DropDownList(
                    list = WINGS,
                    label = stringResource(R.string.wing),
                    selectedItem = viewModel.note.wing,
                    onClick = { selectedItem -> viewModel.onEvent(NoteEvent.OnNoteWingChange(selectedItem)) },
                    modifier = Modifier.fillMaxWidth(.75f)
                )
                DropDownList(
                    list = MOON,
                    label = stringResource(R.string.moon),
                    selectedItem = viewModel.note.moon,
                    onClick = { selectedItem -> viewModel.onEvent(NoteEvent.OnNoteMoonChange(selectedItem)) },
                    modifier = Modifier.fillMaxWidth(.75f)
                )
            }
            OutlinedTextEdit(
                value = viewModel.note.note,
                label = stringResource(R.string.note),
                onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNoteNoteChange(newValue)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                height = 160.dp,
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
            )
            Text(
                text = stringResource(R.string.add_photo),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    if (viewModel.note.id != NEW_ID) {
                        launcher.launch("image/*")
                    } else {
                        openDialogNewNote = true
                    }
                },
            )

            LazyRow {
                items(viewModel.photos) { photo ->
                    ShowPhoto(
                        photo,
                        onClick = { value ->
                            when (value) {
                                MAIN ->
                                    viewModel.onEvent(
                                        NoteEvent.OnNoteSetMainPhoto(
                                            noteId = photo.noteId,
                                            id = photo.id
                                        )
                                    )

                                VIEW -> toPhoto(PhotoDestination(photo.noteId, photo.photoPath))

                                DELETE -> {
                                    selectedPhoto = photo
                                    openDialogDeletePhoto = true
                                }
                            }
                        }
                    )
                }
            }
            HorizontalDivider(
                thickness = 1.dp,
            )
            OkAndCancel(
                titleOk = stringResource(R.string.save),
                enabledOk = true,
                onOK = { viewModel.onEvent(NoteEvent.OnNoteSave) },
                onCancel = { toNoteList() },
            )
        }
    }
    if (showDatePicker) {
        SetDate(
            datePickerState = datePickerState,
            onDismissRequest = { showDatePicker = false },
            onClickConfirm = {
                val selectedDate = (datePickerState.selectedDateMillis!!)
                viewModel.onEvent(NoteEvent.OnNoteDateChange(selectedDate))
                showDatePicker = false
            },
            onClickCancel = { showDatePicker = false }
        )
    }
    if (openDialogNewNote) {
        DialogText(
            text = "Заметка ещё не сохранена, чтобы добавить фото надо сначала сохранить заметку.\n\tСохранить?",
            showCancel = true,
            onDismiss = {},
            titleOK = stringResource(R.string.yes),
            titleCancel = stringResource(R.string.no),
            onOK = {
                viewModel.onEvent(NoteEvent.OnNoteSave)
                openDialogNewNote = false
            },
            onCancel = { openDialogNewNote = false },
        )
    }
    if (openDialogDeletePhoto) {
        toLog("selectedPhoto: $selectedPhoto")
        DialogText(
            text = "Вы действительно хотите удалить фотографию из заметки?",
            showCancel = true,
            onDismiss = {},
            titleOK = stringResource(R.string.yes),
            titleCancel = stringResource(R.string.no),
            onOK = {
                viewModel.onEvent(NoteEvent.OnNotePhotoDelete(selectedPhoto))
                openDialogDeletePhoto = false
            },
            onCancel = { openDialogDeletePhoto = false },
        )
    }
}

@Composable
private fun ShowDate(
    date: Long,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = date.asDate(),
            lineHeight = .1.em
        )
        IconButton(
            onClick = onClick
        ) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = null,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(25)
                    )
                    .padding(4.dp),
            )
        }
    }
}

@Composable
private fun SetParameter(
    value: String,
    label: String,
    width: Dp = 48.dp,
    keyboardType: KeyboardType = KeyboardType.Unspecified,
    onChange: (String) -> Unit
) {
    Text(label)
    OutlinedTextEdit(
        value = value,
        onChange = { newValue -> onChange(newValue) },
        textAlign = TextAlign.Center,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
        ),
        height = 40.dp,
        modifier = Modifier
            .padding(4.dp)
            .width(width)
    )
}

@Composable
private fun ShowPhoto(
    photo: NotePhotoEntity,
    onClick: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier.clickable(
            onClick = { expanded = true }
        ),
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = photo.photoPath.toUri()),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    start = 4.dp,
                    end = 4.dp,
                    bottom = 8.dp,
                )
                .requiredSize(dimensionResource(id = R.dimen.small_size_photo))
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        if (photo.isMain) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "check",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                        end = 12.dp,
                    )
                    .size(12.dp)
                    .background(Color.White)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            PHOTO_MENU_ITEM.forEachIndexed { idx, item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onClick(idx)
                        expanded = false
                    },
                    //modifier = Modifier.height(24.dp)
                )
                if (item != PHOTO_MENU_ITEM.last())
                    HorizontalDivider(thickness = 1.dp)
            }
        }
    }
}