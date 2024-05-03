package com.example.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.database.PokemonsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(context: Context): PokemonsDatabase {
        return Room.databaseBuilder(context, PokemonsDatabase::class.java, DB_NAME).addMigrations(MIGRATION_1_2).build()
    }

    private val MIGRATION_1_2: Migration = object: Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE pokemon ADD COLUMN loadingError TEXT")
            db.execSQL("ALTER TABLE pokemon ADD COLUMN haveDetailInfo INTEGER DEFAULT 0 NOT NULL")
        }
    }
    companion object {
        private const val DB_NAME = "pokemonDb"
    }
}