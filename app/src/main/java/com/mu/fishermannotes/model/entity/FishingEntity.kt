package com.mu.fishermannotes.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "fishing_table",
    foreignKeys = [
        ForeignKey(entity = LocationEntity::class,
            parentColumns = ["id"],
            childColumns = ["locationId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FishingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val locationId: Int,
    val temperature: Int,
    val condition: String,
    val wind: String,
    val moonImage: Int,
    val date: String,
    val note: String
)

