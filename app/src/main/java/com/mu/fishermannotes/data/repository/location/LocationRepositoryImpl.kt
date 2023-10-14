package com.mu.fishermannotes.data.repository.location

import com.mu.fishermannotes.data.LocationDao
import com.mu.fishermannotes.model.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

class LocationRepositoryImpl(
    private val dao: LocationDao
) : LocationRepository {
    override suspend fun insert(location: LocationEntity) {
        dao.insert(location)
    }

    override suspend fun delete(location: LocationEntity) {
        dao.delete(location)
    }

    override fun getLocations(): Flow<List<LocationEntity>> {
        return dao.getLocations()
    }

    override fun getLocationById(id: Int): Flow<LocationEntity> {
        return dao.getLocationById(id)
    }
}