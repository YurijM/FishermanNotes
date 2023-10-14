package com.mu.fishermannotes.data.repository.fishing_photo

import com.mu.fishermannotes.data.FishingPhotoDao
import com.mu.fishermannotes.model.entity.FishingPhotoEntity
import kotlinx.coroutines.flow.Flow

class FishingPhotoRepositoryImpl(
    private val dao: FishingPhotoDao
) : FishingPhotoRepository{
    override suspend fun insert(itemFishingPhoto: FishingPhotoEntity) {
        dao.insert(itemFishingPhoto)
    }

    override suspend fun delete(itemFishingPhoto: FishingPhotoEntity) {
        dao.delete(itemFishingPhoto)
    }

    override fun getFishingPhotos(fishingId: Int): Flow<List<FishingPhotoEntity>> {
        return getFishingPhotos(fishingId)
    }
}