package com.tecacet.fc4

import org.jgrapht.alg.TransitiveReduction
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WeaponsGraphKtTest {

    @Test
    fun buildSidearmGraph() {
        val weapons = readWeapons("sidearms.csv")
        val graph = buildGraph(weapons)
        assertEquals(17, graph.vertexSet().size)
        assertEquals(33, graph.edgeSet().size)

        //Eliminate dependencies that are inferred by transitivity
        TransitiveReduction.INSTANCE.reduce(graph)
        assertEquals(17, graph.vertexSet().size)
        assertEquals(21, graph.edgeSet().size)



    }
}