package com.example.simplestopwatchapp

import com.example.simplestopwatchapp.ui.presentation.convertDigitToTimerFormat
import org.junit.Test

import org.junit.Assert.*
import org.junit.Assert.assertEquals


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */



class TimerFormatTest {

    @Test
    fun `test digit less than 10 returns correct format`() {
        assertEquals("00:00:01", convertDigitToTimerFormat(1))
        assertEquals("00:00:05", convertDigitToTimerFormat(5))
        assertEquals("00:00:09", convertDigitToTimerFormat(9))
    }

    @Test
    fun `test digit between 10 and 59 returns correct format`() {
        assertEquals("00:00:10", convertDigitToTimerFormat(10))
        assertEquals("00:00:30", convertDigitToTimerFormat(30))
        assertEquals("00:00:59", convertDigitToTimerFormat(59))
    }

    @Test
    fun `test digit between 60 and 3599 returns correct format`() {
        assertEquals("00:01:00", convertDigitToTimerFormat(60))  // Exactly 1 minute
        assertEquals("00:05:00", convertDigitToTimerFormat(300)) // 5 minutes
        assertEquals("00:59:59", convertDigitToTimerFormat(3599)) // Just below an hour
    }

    @Test
    fun `test digit greater than or equal to 3600 returns correct format`() {
        assertEquals("01:00:00", convertDigitToTimerFormat(3600)) // Exactly 1 hour
        assertEquals("02:00:00", convertDigitToTimerFormat(7200)) // Exactly 2 hours
        assertEquals("01:30:00", convertDigitToTimerFormat(5400)) // 1 hour 30 minutes
        assertEquals("10:00:00", convertDigitToTimerFormat(36000)) // 10 hours
    }

    @Test
    fun `test edge case for 0 seconds`() {
        assertEquals("00:00:00", convertDigitToTimerFormat(0))
    }

    @Test
    fun `test very large values return correct format`() {
        assertEquals("100:00:00", convertDigitToTimerFormat(360000)) // 100 hours
    }
}

