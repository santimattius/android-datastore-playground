package com.santimattius.datastore.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.datastore.data.LocalDataSource
import com.santimattius.datastore.data.datastore.DataStoreLocalDataSource
import com.santimattius.datastore.data.datastore.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataStore(app: Application) = app.dataStore

    @Provides
    fun provideLocalDataSource(preference: DataStore<Preferences>):LocalDataSource =
        DataStoreLocalDataSource(preference)
}