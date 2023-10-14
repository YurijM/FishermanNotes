package com.mu.fishermannotes.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "fishing_fish_table",
    indices = [Index(value = ["fishingId", "fishId"], unique = true)],
    foreignKeys = [
        ForeignKey(entity = FishingEntity::class,
            parentColumns = ["id"],
            childColumns = ["fishingId"],
            onDelete = CASCADE),
        ForeignKey(entity = FishEntity::class,
            parentColumns = ["id"],
            childColumns = ["fishId"],
            onDelete = CASCADE),
    ]
)
data class FishingFishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fishingId: Int,
    val fishId: Int,
    val fishCount: Int,
    val fishWeight: Float,
)

