package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.mu.fishermannotes.R
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.presentation.component.DialogText
import com.mu.fishermannotes.presentation.utils.asDate

@Composable
fun NoteListItemScreen(
    note: NoteEntity,
    photo: NotePhotoEntity?,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }
    val paramsCount = if (note.temperature.isBlank()) 0 else 1 +
            if (note.pressure.isBlank()) 0 else 1 +
            if (note.wing.isBlank()) 0 else 1 +
            if (note.moon.isBlank()) 0 else 1
    /*val paramsAreBlank = note.temperature.isBlank()
            && note.pressure.isBlank()
            && note.wing.isBlank()
            && note.moon.isBlank()*/
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .clickable { onEdit() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight(),
            ) {
                Image(
                    painter = if (photo != null)
                        rememberAsyncImagePainter(model = photo.photoPath.toUri())
                    else
                        painterResource(R.drawable.fishing),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = (4 * paramsCount).dp)
                        .requiredSize(dimensionResource(id = R.dimen.medium_size_photo))
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                )
                IconButton(
                    onClick = { openDialog = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.error,
                                shape = RoundedCornerShape(50)
                            )
                            .padding(8.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    ),
            ) {
                Text(
                    text = note.date.asDate(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    lineHeight = 1.em,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = note.location,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 1.em,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                if (note.temperature.isNotBlank())
                    Text(
                        text = stringResource(R.string.temperature) + " " + note.temperature,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.End,
                        lineHeight = 1.em,
                        modifier = Modifier.fillMaxWidth()
                    )
                if (note.pressure.isNotBlank())
                    Text(
                        text = "${stringResource(R.string.pressure)} ${note.pressure} мм рт.ст.",
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.End,
                        lineHeight = 1.em,
                        modifier = Modifier.fillMaxWidth()
                    )
                if (note.wing.isNotBlank())
                    Text(
                        text = stringResource(R.string.wing) + " " + note.wing,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.End,
                        lineHeight = 1.em,
                        modifier = Modifier.fillMaxWidth()
                    )
                if (note.moon.isNotBlank())
                    Text(
                        text = note.moon,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.End,
                        lineHeight = 1.em,
                        modifier = Modifier.fillMaxWidth()
                    )
                if (paramsCount > 0)
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color.LightGray,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                Text(
                    text = note.note,
                    maxLines = 3,
                    lineHeight = 1.em,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
    if (openDialog) {
        DialogText(
            text = "Вы действительно хотите удалить заметку от ${note.date.asDate()}?",
            showCancel = true,
            onDismiss = {},
            titleOK = stringResource(R.string.yes),
            titleCancel = stringResource(R.string.no),
            onOK = {
                onDelete()
                openDialog = false
            },
            onCancel = { openDialog = false },
        )
    }
}