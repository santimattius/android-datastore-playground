package com.santimattius.datastore.di

import com.santimattius.datastore.data.CounterRepository
import com.santimattius.datastore.domain.Counter
import com.santimattius.datastore.domain.Increment
import com.santimattius.datastore.domain.Restart
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UiModule {

    @Provides
    @ViewModelScoped
    fun provideCounter(repository: CounterRepository) = Counter(repository)

    @Provides
    @ViewModelScoped
    fun provideIncrement(repository: CounterRepository) = Increment(repository)

    @Provides
    @ViewModelScoped
    fun provideRestart(repository: CounterRepository) = Restart(repository)
}