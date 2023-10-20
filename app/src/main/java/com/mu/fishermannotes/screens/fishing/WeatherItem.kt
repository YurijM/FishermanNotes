package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.fishermannotes.R
import com.mu.fishermannotes.ui.theme.lightBlue300
import com.mu.fishermannotes.ui.theme.lightBlue700

@Composable
fun WeatherItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(28.dp),
            painter = painterResource(id = R.drawable.partly_cloudy),
            contentDescription = "condition"
        )
        Text(
            text = "+8º,",
            color = lightBlue300,
            fontSize = 14.sp
        )
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.wind_se),
            tint = lightBlue700,
            contentDescription = "wind"
        )
        Text(
            text = "5-8 м/с,",
            color = lightBlue300,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.waning_gibbous),
            contentDescription = "moon"
        )
    }
}