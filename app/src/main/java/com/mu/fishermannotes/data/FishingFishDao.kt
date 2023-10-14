package com.mu.fishermannotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.model.entity.FishingFishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FishingFishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemFishingFish: FishingFishEntity)

    @Delete
    suspend fun delete(itemFishingFish: FishingFishEntity)

    @Query(
        "SELECT id, fishingId, fishId, fishCount, fishWeight FROM fishing_fish_table " +
                "WHERE fishingId = :fishingId"
    )
    fun getFishingFish(fishingId: Int): Flow<List<FishingFishEntity>>
}