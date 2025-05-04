package com.mu.fishermannotes.presentation.screen.note

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.mu.fishermannotes.R
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.presentation.component.DialogText
import com.mu.fishermannotes.presentation.component.OkAndCancel
import com.mu.fishermannotes.presentation.component.OutlinedTextField
import com.mu.fishermannotes.presentation.component.SetDate
import com.mu.fishermannotes.presentation.component.Title
import com.mu.fishermannotes.presentation.utils.NEW_ID
import com.mu.fishermannotes.presentation.utils.asDate
import com.mu.fishermannotes.presentation.utils.toLog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    toNoteList: () -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = viewModel.note.date
    )
    var expanded by remember { mutableStateOf(false) }
    var openDialog by remember { mutableStateOf(false) }

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            imageUri = uri
        }
    }

    LaunchedEffect(key1 = viewModel.note) {
        toLog("note: ${viewModel.note}")
        toLog("photos: ${viewModel.photos}")
        if (viewModel.executeLauncher) {
            launcher.launch("image/*")
            viewModel.onEvent(NoteEvent.OnNoteExecuteLauncherChange(false))
        }

        if (viewModel.exit) toNoteList()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier.fillMaxWidth(.9f)
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
                SetDate(
                    date = viewModel.note.date,
                    onClick = { showDatePicker = true }
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1.5f)
                    ) {
                        SetParameter(
                            value = viewModel.note.temperature,
                            label = stringResource(R.string.temperature),
                            onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNoteTemperatureChange(newValue)) }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp)
                    ) {
                        SetParameter(
                            value = viewModel.note.wing,
                            label = stringResource(R.string.wing),
                            onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNoteWingChange(newValue)) }
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1.5f)
                    ) {
                        SetParameter(
                            value = viewModel.note.pressure,
                            label = "${stringResource(R.string.pressure)} (мм рт.ст.)",
                            onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNotePressureChange(newValue)) }
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp)
                    ) {
                        SetParameter(
                            value = viewModel.note.moon,
                            label = stringResource(R.string.moon),
                            onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNotePressureChange(newValue)) }
                        )
                    }
                }
                OutlinedTextField(
                    value = viewModel.note.note,
                    label = stringResource(R.string.note),
                    onChange = { newValue -> viewModel.onEvent(NoteEvent.OnNoteNoteChange(newValue)) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword,
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
                            openDialog = true
                        }
                    },
                )

                LazyRow {
                    items(viewModel.photos) { photo ->
                        ShowPhoto(
                            photo,
                            expanded,
                            onClick = { value -> expanded = value }
                        )
                    }
                }
                if (imageUri != null) {
                    viewModel.onEvent(
                        NoteEvent.OnNotePhotoSave(
                            NotePhotoEntity(
                                noteId = viewModel.note.id,
                                photoPath = imageUri.toString()
                            )
                        )
                    )
                    /*Box(
                        contentAlignment = Alignment.TopEnd,
                        modifier = Modifier.clickable(
                            onClick = { expanded = true }
                        ),

                        ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = imageUri),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    top = 4.dp,
                                    bottom = 8.dp,
                                )
                                //.requiredSize(dimensionResource(id = R.dimen.profile_photo_size))
                                .requiredSize(50.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                            //alpha = .75f
                        )
                        if (true) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "check",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .padding(
                                        top = 8.dp,
                                        end = 4.dp
                                    )
                                    .size(12.dp)
                                    .background(Color.White)
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            DropdownMenuItem(
                                text = { Text(stringResource(R.string.make_to_main)) },
                                onClick = {
                                    expanded = false
                                },
                                modifier = Modifier.height(24.dp)
                            )
                            HorizontalDivider(thickness = 1.dp)
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = buildAnnotatedString {
                                            append(stringResource(R.string.view))
                                            withStyle(
                                                style = SpanStyle(fontSize = 12.sp)
                                            ) {
                                                append(" (двойной щелчок)")
                                            }
                                        })
                                },
                                onClick = {
                                    expanded = false
                                },
                                modifier = Modifier.height(24.dp)
                            )
                            HorizontalDivider(thickness = 1.dp)
                            DropdownMenuItem(
                                text = { Text(stringResource(R.string.delete)) },
                                onClick = {
                                    expanded = false
                                },
                                modifier = Modifier.height(24.dp)
                            )
                        }
                    }*/
                }
                HorizontalDivider(
                    thickness = 1.dp,
                )
                /*if (viewModel.error.isNotBlank())
                TextError(
                    error = viewModel.error,
                    textAlign = TextAlign.Center
                )*/
                OkAndCancel(
                    titleOk = stringResource(R.string.save),
                    enabledOk = true,
                    onOK = { viewModel.onEvent(NoteEvent.OnNoteSave) },
                    onCancel = { toNoteList() },
                )
            }
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
    if (openDialog) {
        DialogText(
            text = "Заметка ещё не сохранена, чтобы добавить фото надо сначала сохранить заметку. Сохранить?",
            showCancel = true,
            onDismiss = {},
            titleOK = stringResource(R.string.yes),
            titleCancel = stringResource(R.string.no),
            onOK = {
                viewModel.onEvent(NoteEvent.OnNoteSave)
                openDialog = false
            },
            onCancel = { openDialog = false },
        )
    }
}

@Composable
private fun SetDate(
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
    onChange: (String) -> Unit
) {
    Text(label)
    OutlinedTextField(
        value = value,
        onChange = { newValue -> onChange(newValue) },
        textAlign = TextAlign.Center,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
        ),
        height = 40.dp,
        modifier = Modifier
            .padding(4.dp)
            .width(40.dp)
    )
}

@Composable
private fun ShowPhoto(
    photo: NotePhotoEntity,
    expanded: Boolean,
    onClick: (Boolean) -> Unit
) {
    val uri = photo.photoPath.toUri()
    toLog("ShowPhoto - uri: $uri")
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier.clickable(
            onClick = { onClick(true) }
        ),

        ) {
        Image(
            //painter = rememberAsyncImagePainter(model = photo.photoPath),
            painter = rememberAsyncImagePainter(model = uri),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    bottom = 8.dp,
                )
                //.requiredSize(dimensionResource(id = R.dimen.profile_photo_size))
                .requiredSize(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            //alpha = .75f
        )
        if (photo.isMain) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "check",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        end = 4.dp
                    )
                    .size(12.dp)
                    .background(Color.White)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onClick(false) },
        ) {
            DropdownMenuItem(
                text = { Text(stringResource(R.string.make_to_main)) },
                onClick = { onClick(false) },
                modifier = Modifier.height(24.dp)
            )
            HorizontalDivider(thickness = 1.dp)
            DropdownMenuItem(
                text = {
                    Text(
                        text = buildAnnotatedString {
                            append(stringResource(R.string.view))
                            withStyle(
                                style = SpanStyle(fontSize = 12.sp)
                            ) {
                                append(" (двойной щелчок)")
                            }
                        })
                },
                onClick = { onClick(false) },
                modifier = Modifier.height(24.dp)
            )
            HorizontalDivider(thickness = 1.dp)
            DropdownMenuItem(
                text = { Text(stringResource(R.string.delete)) },
                onClick = { onClick(false) },
                modifier = Modifier.height(24.dp)
            )
        }
    }
}