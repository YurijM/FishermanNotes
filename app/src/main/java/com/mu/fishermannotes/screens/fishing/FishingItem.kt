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
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = lightBlue50,
            contentColor = lightBlue600
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(.5f)
            ) {
                Text(
                    text = "01.10.2023",
                    //color = lightBlue600,
                    fontWeight = FontWeight.Bold
                )
                WeatherItem()
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Терконзавод,\nсанаторий 'Минеральные Воды'",
                    //color = lightBlue600,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Bold
                    //maxLines = 5,
                    //overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                ResultItem()
            }
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.location),
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