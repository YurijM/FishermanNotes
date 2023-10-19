package com.mu.fishermannotes.screens.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.fishermannotes.R
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue500
import com.mu.fishermannotes.ui.theme.lightBlue600

@Composable
fun LocationItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
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
                modifier = Modifier
                    .fillMaxWidth(.5f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        modifier = Modifier.size(20.dp),
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "delete",
                            tint = lightBlue500,
                        )
                    }
                    IconButton(
                        modifier = Modifier.size(20.dp),
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "edit",
                            tint = lightBlue500,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Терконзавод,\nсанаторий 'Минеральные Воды'",
                    lineHeight = 16.sp,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.location),
                contentDescription = "location",
                contentScale = ContentScale.Fit
            )
        }
    }
}