package com.mu.fishermannotes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "table_photos",
    indices = [
        Index(value = ["note_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = NoteEntity::class,
            parentColumns = ["id"],
            childColumns = ["note_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]

)
data class NotePhotoEntity(
    @PrimaryKey(true) val id: Long = 0L,
    @ColumnInfo(name = "note_id") val noteId: Long = 0L,
    @ColumnInfo(name = "photo_path") val photoPath: String = "",
    @ColumnInfo(name = "is_main") val isMain: Boolean = false
)
