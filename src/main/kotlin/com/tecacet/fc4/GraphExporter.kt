package com.tecacet.fc4

import org.jgrapht.Graph
import java.lang.StringBuilder

fun toDagitty(graph: Graph<Weapon, Edge>) : String {
    val builder = StringBuilder("dag {\n")
    graph.edgeSet().forEach {
        builder.append("\"${it.source()}\" -> \"${it.target()}\"\n")
    }
    builder.append("}")
    return builder.toString()
}