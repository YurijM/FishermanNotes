package com.mu.fishermannotes.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mu.fishermannotes.R
import com.mu.fishermannotes.presentation.utils.YEAR_START
import java.util.Calendar

@Composable
fun BottomBar() {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val years = YEAR_START.toString() +
            if (currentYear != YEAR_START) {
                "-$currentYear"
            } else {
                ""
            } + " ©"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.author),
            contentDescription = "author",
            modifier = Modifier.size(28.dp),
        )
        Text(
            text = years,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }

}