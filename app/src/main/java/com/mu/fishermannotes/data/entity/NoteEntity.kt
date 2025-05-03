package com.mu.fishermannotes.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "table_notes"
)
data class NoteEntity(
    @PrimaryKey(true) val id: Long = 0L,
    val date: Long = 0L,
    val location: String = "",
    val temperature: String = "",
    val wing: String = "",
    val moon: String = "",
    val pressure: String = "",
    val note: String = ""
)
