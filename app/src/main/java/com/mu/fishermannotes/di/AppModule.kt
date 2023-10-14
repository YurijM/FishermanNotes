package com.mu.fishermannotes.di

import android.app.Application
import androidx.room.Room
import com.mu.fishermannotes.data.ApplicationDb
import com.mu.fishermannotes.data.repository.fish.FishRepository
import com.mu.fishermannotes.data.repository.fish.FishRepositoryImpl
import com.mu.fishermannotes.data.repository.fishing.FishingRepository
import com.mu.fishermannotes.data.repository.fishing.FishingRepositoryImpl
import com.mu.fishermannotes.data.repository.fishing_fish.FishingFishRepository
import com.mu.fishermannotes.data.repository.fishing_fish.FishingFishRepositoryImpl
import com.mu.fishermannotes.data.repository.fishing_photo.FishingPhotoRepository
import com.mu.fishermannotes.data.repository.fishing_photo.FishingPhotoRepositoryImpl
import com.mu.fishermannotes.data.repository.location.LocationRepository
import com.mu.fishermannotes.data.repository.location.LocationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApplicationDb(app: Application): ApplicationDb {
        return Room.databaseBuilder(
            app,
            ApplicationDb::class.java,
            "fisherman_notes_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFishRepository(db: ApplicationDb): FishRepository {
        return FishRepositoryImpl(db.fishDao)
    }

    @Provides
    @Singleton
    fun provideFishingRepository(db: ApplicationDb): FishingRepository {
        return FishingRepositoryImpl(db.fishingDao)
    }

    @Provides
    @Singleton
    fun provideFishingFishRepository(db: ApplicationDb): FishingFishRepository {
        return FishingFishRepositoryImpl(db.fishingFishDao)
    }

    @Provides
    @Singleton
    fun provideFishingPhotoRepository(db: ApplicationDb): FishingPhotoRepository {
        return FishingPhotoRepositoryImpl(db.fishingPhotoDao)
    }

    @Provides
    @Singleton
    fun provideLocationRepository(db: ApplicationDb): LocationRepository {
        return LocationRepositoryImpl(db.locationDao)
    }
}