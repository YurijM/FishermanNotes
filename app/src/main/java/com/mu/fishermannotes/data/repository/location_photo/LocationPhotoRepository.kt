package com.mu.fishermannotes.data.repository.location_photo

import com.mu.fishermannotes.model.entity.LocationPhotoEntity
import kotlinx.coroutines.flow.Flow

interface LocationPhotoRepository {
    suspend fun insert(itemLocationPhoto: LocationPhotoEntity)
    suspend fun delete(itemLocationPhoto: LocationPhotoEntity)
    fun getLocationPhotos(locationId: Int): Flow<List<LocationPhotoEntity>>
}