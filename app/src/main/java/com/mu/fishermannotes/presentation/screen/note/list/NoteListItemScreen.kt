package com.mu.fishermannotes.presentation.screen.note.list

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.mu.fishermannotes.R
import com.mu.fishermannotes.data.entity.NoteEntity
import com.mu.fishermannotes.data.entity.NotePhotoEntity
import com.mu.fishermannotes.presentation.utils.asDate
import com.mu.fishermannotes.presentation.utils.toLog

@Composable
fun NoteListItemScreen(
    note: NoteEntity,
    photo: NotePhotoEntity?,
    onClick: () -> Unit
) {
	val context = LocalContext.current
	//val uri = Uri.parse("content://media/picker/0/com.android.providers.media.photopicker/media/1000000020")
	val uri = photo?.photoPath?.toUri()
    /*if (uri != null)
	    context.contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)*/

    //val uri = photo?.photoPath?.toUri()
    toLog("uri: $uri")
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
            .clickable { onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            /*AsyncImage(
                model = uri,
                //placeholder = placeholder,
                contentDescription = "User Photo",
                contentScale = ContentScale.Crop,
                //onSuccess = { loadingPhoto = false },
                //colorFilter = if (loadingPhoto) ColorFilter.tint(Color2) else null,
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f / 1f)
                    .clip(RoundedCornerShape(8.dp))
            )*/
            Image(
                //painter = rememberAsyncImagePainter(model = photo.photoPath),
                painter = rememberAsyncImagePainter(model = uri),
                contentDescription = null,
                modifier = Modifier
                    //.requiredSize(dimensionResource(id = R.dimen.profile_photo_size))
                    .requiredSize(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                //alpha = .75f
            )

            Text(
                text = note.date.asDate(),
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}