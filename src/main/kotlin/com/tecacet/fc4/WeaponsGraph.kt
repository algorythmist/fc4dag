package com.tecacet.fc4

import org.jgrapht.Graph
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge

class Edge : DefaultEdge() {

    fun source(): Weapon = super.getSource() as Weapon
    fun target(): Weapon = super.getTarget() as Weapon
}

fun buildGraph(weapons: List<Weapon>): Graph<Weapon, Edge> {
    val partialOrdering = InducedPartialOrdering(Weapon::stats)
    val graph = DefaultDirectedGraph<Weapon, Edge>(Edge::class.java)

    for (w in weapons) {
        graph.addVertex(w)
        for (v in weapons) {
            if (v == w || partialOrdering.compare(v, w) == 0) {
                continue
            }
            graph.addVertex(v)
            if (partialOrdering.compare(w, v) > 0) {
                graph.addEdge(w, v)
            } else if (partialOrdering.compare(w, v) < 0) {
                graph.addEdge(v, w)
            }
        }
    }
    return graph
}