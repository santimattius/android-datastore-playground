package com.santimattius.datastore.domain

import com.santimattius.datastore.data.CounterRepository

class Counter(private val repository: CounterRepository) {

    operator fun invoke() = repository.value()
}