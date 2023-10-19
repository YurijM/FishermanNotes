package com.mu.fishermannotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.model.entity.LocationPhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationPhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemLocationPhoto: LocationPhotoEntity)

    @Delete
    suspend fun delete(itemLocationPhoto: LocationPhotoEntity)

    @Query(
        "SELECT id, locationId, photoId FROM location_photo_table " +
                "WHERE locationId = :locationId"
    )
    fun getLocationPhotos(locationId: Int): Flow<List<LocationPhotoEntity>>
}