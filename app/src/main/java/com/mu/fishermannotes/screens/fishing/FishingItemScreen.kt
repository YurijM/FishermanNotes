package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.fishermannotes.R
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue600

@Preview(showBackground = true)
@Composable
fun FishingItemScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(lightBlue50)
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(.5f)
            ) {
                Text(
                    text = "01.10.2023",
                    color = lightBlue600,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.waning_gibbous),
                    contentDescription = "moon"                )
                /*Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.waning_gibbous),
                    contentDescription = "moon"
                )*/
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Терконзавод,\nсанаторий 'Минеральные Воды'",
                    color = lightBlue600,
                    lineHeight = 16.sp
                    //maxLines = 5,
                    //overflow = TextOverflow.Ellipsis

                )
            }
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.location),
                contentDescription = "fishman",
                contentScale = ContentScale.Fit
            )
        }
    }
}