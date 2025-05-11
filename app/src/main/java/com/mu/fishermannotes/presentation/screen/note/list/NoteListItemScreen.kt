package com.mu.fishermannotes.presentation.screen.note.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.mu.fishermannotes.R
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.presentation.utils.asDate

@Composable
fun NoteListItemScreen(
    note: NoteEntity,
    photo: NotePhotoEntity?,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onEdit() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Image(
                painter = if (photo != null)
                    rememberAsyncImagePainter(model = photo.photoPath.toUri())
                else
                    painterResource(R.drawable.fishing),
                contentDescription = null,
                modifier = Modifier
                    .requiredSize(dimensionResource(id = R.dimen.medium_size_photo))
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(.85f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = note.date.asDate()
                )
                Text(
                    text = note.location,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                if (note.temperature.isNotBlank())
                    Text(
                        text = stringResource(R.string.temperature) + " " + note.temperature,
                        modifier = Modifier.fillMaxWidth()
                    )
                if (note.pressure.isNotBlank())
                    Text(
                        text = "${stringResource(R.string.pressure)} ${note.pressure} мм рт.ст.",
                        modifier = Modifier.fillMaxWidth()
                    )
                if (note.wing.isNotBlank())
                    Text(
                        text = stringResource(R.string.wing) + " " + note.wing,
                        modifier = Modifier.fillMaxWidth()
                    )
                if (note.moon.isNotBlank())
                    Text(
                        text = stringResource(R.string.moon) + " " + note.moon,
                        modifier = Modifier.fillMaxWidth()
                    )
            }
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { onDelete() },
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
        }
    }
}