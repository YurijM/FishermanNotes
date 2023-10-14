package com.mu.fishermannotes.data.repository.fish

import com.mu.fishermannotes.model.entity.FishEntity
import kotlinx.coroutines.flow.Flow

interface FishRepository {
    suspend fun insert(fish: FishEntity)
    suspend fun delete(fish: FishEntity)
    fun getFishes(): Flow<List<FishEntity>>
}