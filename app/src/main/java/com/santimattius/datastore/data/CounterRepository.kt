package com.santimattius.datastore.data

class CounterRepository(
    private val dataSource: LocalDataSource,
) {

    fun value() = dataSource.counterValue()

    suspend fun increment() = dataSource.incrementCounter()

    suspend fun restart() = dataSource.restart()
}