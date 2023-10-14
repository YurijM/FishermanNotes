package com.mu.fishermannotes.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fish_table")
data class FishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fish: String
)
