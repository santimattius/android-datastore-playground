package com.santimattius.datastore.domain

import com.santimattius.datastore.data.CounterRepository

class Restart(private val repository: CounterRepository) {

    suspend operator fun invoke() = repository.restart()
}