package com.mu.fishermannotes.presentation.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun toLog(message: String) {
    Log.d(DEBUG_TAG, message)
}

fun Long.asDate(): String {
    val format = "dd.MM.y"
    val formatter = SimpleDateFormat(format, Locale.getDefault())

    return try {
        formatter.format(Date(this))
    } catch (e: Exception) {
        toLog("Ошибка Long.asDate: ${e.message}")
        ""
    }
}
