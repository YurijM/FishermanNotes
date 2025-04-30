package com.mu.fishermannotes.presentation.screen.note

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mu.fishermannotes.presentation.component.OkAndCancel

@Composable
fun NoteScreen(
    viewModel: NoteViewModel = hiltViewModel()
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(vertical = 12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                HorizontalDivider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 8.dp)
                )
                /*if (viewModel.error.isNotBlank())
                TextError(
                    error = viewModel.error,
                    textAlign = TextAlign.Center
                )*/
                OkAndCancel(
                    titleOk = "Сохранить",
                    titleCancel = "Отмена",
                    //enabledOk = viewModel.enabledButton,
                    onOK = { },
                    onCancel = { },
                )
            }
        }
    }
}