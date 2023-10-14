package com.mu.fishermannotes.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val location: String,
    val photo: String
)
