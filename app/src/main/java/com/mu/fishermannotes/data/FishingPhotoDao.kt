package com.mu.fishermannotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.model.entity.FishingPhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FishingPhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemFishingPhoto: FishingPhotoEntity)

    @Delete
    suspend fun delete(itemFishingPhoto: FishingPhotoEntity)

    @Query(
        "SELECT id, fishingId, photoId FROM fishing_photo_table " +
                "WHERE fishingId = :fishingId"
    )
    fun getFishingPhotos(fishingId: Int): Flow<List<FishingPhotoEntity>>
}