package com.mu.fishermannotes.data.repository.fishing_photo

import com.mu.fishermannotes.model.entity.FishingPhotoEntity
import kotlinx.coroutines.flow.Flow

interface FishingPhotoRepository {
    suspend fun insert(itemFishingPhoto: FishingPhotoEntity)
    suspend fun delete(itemFishingPhoto: FishingPhotoEntity)
    fun getFishingPhotos(fishingId: Int): Flow<List<FishingPhotoEntity>>
}