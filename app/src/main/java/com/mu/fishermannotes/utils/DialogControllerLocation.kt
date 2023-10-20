package com.mu.fishermannotes.utils

import androidx.compose.runtime.MutableState

interface DialogControllerLocation : DialogController {
    val editLocation: MutableState<String>
}