package com.mu.fishermannotes.data.repository.fishing_fish

import com.mu.fishermannotes.model.entity.FishingFishEntity
import kotlinx.coroutines.flow.Flow

interface FishingFishRepository {
    suspend fun insert(itemFishingFish: FishingFishEntity)
    suspend fun delete(itemFishingFish: FishingFishEntity)
    fun getFishingFish(fishingId: Int): Flow<List<FishingFishEntity>>
}