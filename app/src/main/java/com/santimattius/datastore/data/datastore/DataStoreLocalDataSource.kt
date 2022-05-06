package com.santimattius.datastore.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.santimattius.datastore.data.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreLocalDataSource(
    private val preferences: DataStore<Preferences>,
) : LocalDataSource {

    override fun counterValue(): Flow<Int> = preferences.data.map { preferences ->
        preferences[EXAMPLE_COUNTER] ?: 0
    }

    override suspend fun incrementCounter() {
        preferences.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }

    override suspend fun restart() {
        preferences.edit { settings ->
            settings[EXAMPLE_COUNTER] = 0
        }
    }
}