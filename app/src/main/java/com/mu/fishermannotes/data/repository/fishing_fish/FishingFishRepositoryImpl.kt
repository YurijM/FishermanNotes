package com.mu.fishermannotes.data.repository.fishing_fish

import com.mu.fishermannotes.data.FishingFishDao
import com.mu.fishermannotes.model.entity.FishingFishEntity
import kotlinx.coroutines.flow.Flow

class FishingFishRepositoryImpl(
    private val dao: FishingFishDao
) : FishingFishRepository {
    override suspend fun insert(itemFishingFish: FishingFishEntity) {
        dao.insert(itemFishingFish)
    }

    override suspend fun delete(itemFishingFish: FishingFishEntity) {
        dao.delete(itemFishingFish)
    }

    override fun getFishingFish(fishingId: Int): Flow<List<FishingFishEntity>> {
        return dao.getFishingFish(fishingId)
    }
}