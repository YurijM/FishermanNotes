package com.mu.fishermannotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.model.entity.FishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fish: FishEntity)

    @Delete
    suspend fun delete(fish: FishEntity)

    @Query("SELECT * FROM fish_table")
    fun getFish(): Flow<List<FishEntity>>
}