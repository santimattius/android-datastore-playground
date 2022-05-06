package com.santimattius.datastore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.datastore.domain.Counter
import com.santimattius.datastore.domain.Increment
import com.santimattius.datastore.domain.Restart
import com.santimattius.datastore.ui.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val increment: Increment,
    private val counter: Counter,
    private val restart: Restart,
) : ViewModel() {

    private var job: Job? = null

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow(MainState())

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<MainState> = _uiState

    init {
        viewModelScope.launch {
            counter().collect { currentValue ->
                _uiState.value = _uiState.value.copy(value = currentValue)
            }
        }
    }

    fun increment() {
        singleLaunch { increment.invoke() }
    }

    fun restart() {
        singleLaunch { restart.invoke() }
    }

    private fun singleLaunch(block: suspend () -> Unit) {
        job?.cancel()
        job = viewModelScope.launch { block() }
    }
}