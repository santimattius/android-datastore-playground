package com.santimattius.datastore.data

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun counterValue(): Flow<Int>

    suspend fun incrementCounter()

    suspend fun restart()
}