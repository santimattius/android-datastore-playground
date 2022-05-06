package com.santimattius.datastore.di

import com.santimattius.datastore.data.CounterRepository
import com.santimattius.datastore.data.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(localDataSource: LocalDataSource) =
        CounterRepository(localDataSource)
}