package com.mu.fishermannotes.utils

import androidx.compose.runtime.MutableState

interface DialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val showEditableFields: MutableState<Boolean>
}