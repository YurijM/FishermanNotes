package com.mu.fishermannotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mu.fishermannotes.model.entity.FishEntity
import com.mu.fishermannotes.model.entity.FishingEntity
import com.mu.fishermannotes.model.entity.FishingFishEntity
import com.mu.fishermannotes.model.entity.LocationEntity
import com.mu.fishermannotes.model.entity.LocationPhotoEntity

@Database(
    entities = [
        FishEntity::class,
        FishingEntity::class,
        FishingFishEntity::class,
        LocationEntity::class,
        LocationPhotoEntity::class
    ],
    version = 1
)
abstract class ApplicationDb : RoomDatabase() {
    abstract val fishDao: FishDao
    abstract val fishingDao: FishingDao
    abstract val fishingFishDao: FishingFishDao
    abstract val locationDao: LocationDao
    abstract val locationPhotoDao: LocationPhotoDao
}