package com.mu.fishermannotes.di

import android.app.Application
import androidx.room.Room
import com.mu.fishermannotes.data.FishermanNotesDb
import com.mu.fishermannotes.data.repository.NoteRepositoryImpl
import com.mu.fishermannotes.domain.repository.NoteRepository
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
    fun provideFishermanNotesDb(app: Application): FishermanNotesDb {
        return Room.databaseBuilder(
            app,
            FishermanNotesDb::class.java,
            "db_fishermannotes"
        )
            .addMigrations()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: FishermanNotesDb): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }
}