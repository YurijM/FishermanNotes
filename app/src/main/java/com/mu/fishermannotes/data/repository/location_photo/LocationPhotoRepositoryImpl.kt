package com.mu.fishermannotes.data.repository.location_photo

import com.mu.fishermannotes.data.LocationPhotoDao
import com.mu.fishermannotes.model.entity.LocationPhotoEntity
import kotlinx.coroutines.flow.Flow

class LocationPhotoRepositoryImpl(
    private val dao: LocationPhotoDao
) : LocationPhotoRepository{
    override suspend fun insert(itemLocationPhoto: LocationPhotoEntity) {
        dao.insert(itemLocationPhoto)
    }

    override suspend fun delete(itemLocationPhoto: LocationPhotoEntity) {
        dao.delete(itemLocationPhoto)
    }

    override fun getLocationPhotos(locationId: Int): Flow<List<LocationPhotoEntity>> {
        return dao.getLocationPhotos(locationId)
    }
}