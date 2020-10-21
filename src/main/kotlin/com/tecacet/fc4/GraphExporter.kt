package com.tecacet.fc4

import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.attribute.Shape
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.model.Factory.*
import guru.nidi.graphviz.model.Node
import org.jgrapht.Graph
import java.io.File

fun toDagitty(graph: Graph<Weapon, Edge>): String {
    val builder = StringBuilder("dag {\n")
    graph.edgeSet().forEach {
        builder.append("\"${it.source()}\" -> \"${it.target()}\"\n")
    }
    builder.append("}")
    return builder.toString()
}

fun toGraphviz(g: Graph<Weapon, Edge>, filename: String) {

    var gv = graph("test").directed()
            .graphAttr().with(Color.AZURE) //.with(Rank.dir(Rank.RankDir.BOTTOM_TO_TOP))
            .nodeAttr().with(Shape.BOX)

    val nodes = arrayListOf<Node>()
    g.edgeSet().forEach {
        nodes.add(node(it.source().name).link(to(node(it.target().name))))
    }
    gv = gv.with(nodes)
    Graphviz.fromGraph(gv).render(Format.PNG).toFile(File(filename))

}