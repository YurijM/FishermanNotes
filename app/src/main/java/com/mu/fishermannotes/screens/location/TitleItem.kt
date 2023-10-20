package com.mu.fishermannotes.screens.location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
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