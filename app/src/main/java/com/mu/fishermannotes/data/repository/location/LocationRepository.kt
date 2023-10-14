package com.mu.fishermannotes.data.repository.location

import com.mu.fishermannotes.model.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun insert(location: LocationEntity)
    suspend fun delete(location: LocationEntity)
    fun getLocations(): Flow<List<LocationEntity>>
    fun getLocationById(id: Int): Flow<LocationEntity>
}