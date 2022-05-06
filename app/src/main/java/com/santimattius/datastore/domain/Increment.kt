package com.santimattius.datastore.domain

import com.santimattius.datastore.data.CounterRepository

class Increment(private val repository: CounterRepository) {

    suspend operator fun invoke() = repository.increment()
}