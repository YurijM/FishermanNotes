package com.mu.fishermannotes.presentation.component

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mu.fishermannotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetDate(
    datePickerState: DatePickerState,
    onDismissRequest: () -> Unit,
    onClickConfirm: () -> Unit,
    onClickCancel: () -> Unit,
) {
    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = onClickConfirm
            ) {
                Text(text = stringResource(id = R.string.ok))
            }
        },
        dismissButton = {
            TextButton(
                onClick = onClickCancel
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}