package com.tecacet.fc4

import org.jgrapht.alg.TransitiveReduction
import org.jgrapht.nio.dot.DOTExporter
import java.io.File

fun main() {

    fun quote(str: String) = "\"$str\""

    val weapons = readWeapons("sidearms.csv")
    val graph = buildGraph(weapons)
    TransitiveReduction.INSTANCE.reduce(graph)
    val dagitty = toDagitty(graph)
    println(dagitty)

    val dotExporter = DOTExporter<Weapon, Edge> { quote(it.name) }
    dotExporter.exportGraph(graph, File("sidearms.dot"))
    toGraphviz(graph, "sidearms.png")

}