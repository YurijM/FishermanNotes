package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.fishermannotes.R
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue600

@Composable
fun FishingItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = lightBlue50,
            contentColor = lightBlue600
        )
    ) {
        TitleItem()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(.5f)
            ) {
                WeatherItem()
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Терконзавод,\nсанаторий 'Минеральные Воды'",
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                ResultItem()
            }
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.location_default),
                contentDescription = "location",
                contentScale = ContentScale.Fit
            )
        }
        Divider(
            modifier = Modifier.padding(horizontal = 8.dp),
            color = lightBlue600
        )
        NoteItem()
    }
}