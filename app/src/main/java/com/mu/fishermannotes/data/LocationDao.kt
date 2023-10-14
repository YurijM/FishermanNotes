package com.mu.fishermannotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.fishermannotes.model.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(location: LocationEntity)

    @Delete
    suspend fun delete(location: LocationEntity)

    @Query("SELECT * FROM location_table")
    fun getLocations(): Flow<List<LocationEntity>>

    @Query("SELECT * FROM location_table " +
            "WHERE id = :id")
    fun getLocationById(id: Int): Flow<LocationEntity>
}