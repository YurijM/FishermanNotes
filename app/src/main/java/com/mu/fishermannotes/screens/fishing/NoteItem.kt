package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteItem() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 4.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 8.dp
            ),
        text = "Начал рыбачить в 08.20. Ловил на перловку, кукурузу и опарыша.\n" +
                "Первую плотву поймал в начале 9 на перловку.\n" +
                "Более крупные караси попадались на кукурузу.",
        lineHeight = 16.sp
    )
}