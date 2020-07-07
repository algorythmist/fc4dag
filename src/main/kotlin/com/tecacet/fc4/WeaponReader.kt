package com.tecacet.fc4

import com.tecacet.jflat.*
import org.apache.commons.csv.CSVFormat

fun readWeapons(filename : String) : List<Weapon> {
    val reader : CSVReader<Weapon> =
        CSVReader.createWithIndexMapping(Weapon::class.java,
            arrayOf("name", "type"))
            .withFormat(CSVFormat.DEFAULT.withTrim().withCommentMarker('#'))
    return reader.readAllWithCallback(filename) { rowRecord, weapon ->
        val stats = rowRecord[2].split("/").
        map { it.trim().toInt() }.toIntArray()
        var smallCapacity = -1
        var extendedCapacity = -1
        if (rowRecord.size() > 3) {
            val capacities = rowRecord[3].trim().split("/")
            smallCapacity = capacities[0].toInt()
            extendedCapacity = if (capacities.size > 1) capacities[1].toInt() else smallCapacity
        }
        weapon.resolveStats(stats)
        weapon.capacity = smallCapacity
        weapon.extended = extendedCapacity
    }


}
