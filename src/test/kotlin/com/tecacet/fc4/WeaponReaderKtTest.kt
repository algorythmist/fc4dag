package com.tecacet.fc4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class WeaponReaderKtTest {

    @Test
    fun readSidearms() {
        val weapons = readWeapons("sidearms.csv")
        assertEquals(17, weapons.size)
        val ajm = weapons[3]
        assertEquals("A.J.M. 9", ajm.name)
        assertEquals("PISTOL", ajm.type)
        assertEquals(6, ajm.accuracy)
        assertEquals(6, ajm.damage)
        assertEquals(5, ajm.range)
        assertEquals(4, ajm.fireRate)
        assertEquals(5, ajm.mobility)
        assertEquals(9, ajm.capacity)
        assertEquals(18, ajm.extended)
    }

    @Test
    fun readWeapons() {
        val weapons = readWeapons("weapons.csv")
        assertEquals(25, weapons.size)
    }
}