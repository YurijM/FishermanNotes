package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mu.fishermannotes.R
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue600

@Composable
fun TitleItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(lightBlue600)
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "19.06.2023",
            color = lightBlue50,
            fontWeight = FontWeight.Bold
        )
        Row {
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "edit",
                    tint = lightBlue50,
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "delete",
                    tint = lightBlue50,
                )
            }
        }

    }
}