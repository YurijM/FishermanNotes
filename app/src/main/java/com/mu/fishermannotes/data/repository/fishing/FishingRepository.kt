package com.mu.fishermannotes.data.repository.fishing

import com.mu.fishermannotes.model.Fishing
import com.mu.fishermannotes.model.entity.FishingEntity
import kotlinx.coroutines.flow.Flow

interface FishingRepository {
    suspend fun insert(fishing: FishingEntity)
    suspend fun delete(fishing: FishingEntity)
    fun getFishing(): Flow<List<Fishing>>
    fun deleteFishingFishByFishing(fishingId: Int)
    fun deleteFishingPhotosByFishing(fishingId: Int)
}