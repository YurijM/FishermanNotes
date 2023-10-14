package com.mu.fishermannotes.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "fishing_photo_table",
    indices = [Index(value = ["fishingId", "photoId"], unique = true)],
    foreignKeys = [
        ForeignKey(entity = FishingEntity::class,
            parentColumns = ["id"],
            childColumns = ["fishingId"],
            onDelete = CASCADE),
    ]
)
data class FishingPhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fishingId: Int,
    val photoId: Int
)

