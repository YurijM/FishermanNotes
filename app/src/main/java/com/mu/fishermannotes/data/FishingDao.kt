package com.mu.fishermannotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.model.Fishing
import com.mu.fishermannotes.model.entity.FishingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FishingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fishing: FishingEntity)

    @Delete
    suspend fun delete(fishing: FishingEntity)

    @Query(
        "SELECT f.id, f.condition, f.date, f.moonImage, f.temperature, f.wind, f.note, l.location " +
                "FROM fishing_table f " +
                "INNER JOIN location_table l ON l.id = f.locationId"
    )
    fun getFishing(): Flow<List<Fishing>>

    @Query(
        "DELETE FROM fishing_fish_table " +
                "WHERE fishingId = :fishingId"
    )
    fun deleteFishingFishByFishing(fishingId: Int)

    @Query(
        "DELETE FROM fishing_photo_table " +
                "WHERE fishingId = :fishingId"
    )
    fun deleteFishingPhotosByFishing(fishingId: Int)
}