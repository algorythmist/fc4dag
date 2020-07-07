package com.tecacet.fc4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class ArrayPartialOrderingTest {

    val partialOrdering= ArrayPartialOrdering()

    @Test
    fun illegalComparison() {
        val a1 = IntArray(5)
        val a2 = IntArray(6)
        assertThrows(IllegalArgumentException::class.java) { partialOrdering.compare(a1, a2)}

    }

    @Test
    fun greater() {
        val a1 = intArrayOf(1, 2, 3, 4)
        val a2 = intArrayOf(1, 2, 2, 2)
        assertTrue(partialOrdering.compare(a1, a2) > 0 )
    }

    @Test
    fun less() {
        val a1 = intArrayOf(1, 2, 3, 4)
        val a2 = intArrayOf(1, 2, 4, 5)
        assertTrue(partialOrdering.compare(a1, a2) < 0 )
    }

    @Test
    fun incomparable() {
        val a1 = intArrayOf(1, 2, 3, 4)
        val a2 = intArrayOf(1, 2, 4, 3)
        assertTrue(partialOrdering.compare(a1, a2) == 0 )
    }
}