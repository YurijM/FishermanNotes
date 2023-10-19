package com.mu.fishermannotes.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "location_photo_table",
    indices = [Index(value = ["locationId", "photoId"], unique = true)],
    foreignKeys = [
        ForeignKey(entity = LocationEntity::class,
            parentColumns = ["id"],
            childColumns = ["locationId"],
            onDelete = CASCADE),
    ]
)
data class LocationPhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val locationId: Int,
    val photoId: Int
)

