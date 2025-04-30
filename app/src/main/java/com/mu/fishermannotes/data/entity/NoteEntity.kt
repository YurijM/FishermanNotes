package com.mu.fishermannotes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "table_notes"
)
data class NoteEntity(
    @PrimaryKey(true) val id: Long = 0L,
    @ColumnInfo(name = "photo_path") val photoPath: String = ""
)
