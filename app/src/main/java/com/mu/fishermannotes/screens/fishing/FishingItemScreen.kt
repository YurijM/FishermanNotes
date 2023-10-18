package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mu.fishermannotes.R

@Preview(showBackground = true)
@Composable
fun FishingItemScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(.5f)
        ) {
            Text(
                text = "01.10.2023"
            )
            Text(
                text = "ewf f ew rfwe werfew rewrewrwrt wert" +
                        "wr er ewrt wrtw rtwrt e rtrt rter erer fefefre erfer ere rere rer er" +
                        "fffffffd fdf fdf dfd fdff",
                //maxLines = 5,
                //overflow = TextOverflow.Ellipsis

            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "fishman",
                contentScale = ContentScale.Fit
            )
        }
    }

}