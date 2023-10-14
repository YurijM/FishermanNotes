package com.mu.fishermannotes.data.repository.fish

import com.mu.fishermannotes.data.FishDao
import com.mu.fishermannotes.model.entity.FishEntity
import kotlinx.coroutines.flow.Flow

class FishRepositoryImpl(
    private val dao: FishDao
) : FishRepository {
    override suspend fun insert(fish: FishEntity) {
        dao.insert(fish)
    }

    override suspend fun delete(fish: FishEntity) {
        dao.delete(fish)
    }

    override fun getFishes(): Flow<List<FishEntity>> {
        return dao.getFish()
    }
}