package com.mu.fishermannotes.data.repository.fishing

import com.mu.fishermannotes.data.FishingDao
import com.mu.fishermannotes.model.Fishing
import com.mu.fishermannotes.model.entity.FishingEntity
import kotlinx.coroutines.flow.Flow

class FishingRepositoryImpl(
    private val dao: FishingDao
) : FishingRepository {
    override suspend fun insert(fishing: FishingEntity) {
        dao.insert(fishing)
    }

    override suspend fun delete(fishing: FishingEntity) {
        dao.delete(fishing)
        fishing.id?.let { dao.deleteFishingFishByFishing(it) }
    }

    override fun getFishing(): Flow<List<Fishing>> {
        return dao.getFishing()
    }

    override fun deleteFishingFishByFishing(fishingId: Int) {
    }
}