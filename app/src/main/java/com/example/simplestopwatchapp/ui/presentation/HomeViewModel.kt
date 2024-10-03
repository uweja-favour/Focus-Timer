package com.example.simplestopwatchapp.ui.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel: ViewModel() {

    private val _timerCount = MutableStateFlow(3600)
    val timerCount = _timerCount

    private val _startTimer = MutableStateFlow(false)
    val startTimer = _startTimer

    fun incrementTimer() {
        _timerCount.value += 1
    }

    fun resetTimer() {
        _timerCount.value = 0
        _startTimer.value = false
    }


    fun toggleTimerToStartOrStop(timerStateAsStartOrStop: Boolean) {
        _startTimer.value = timerStateAsStartOrStop
    }

}