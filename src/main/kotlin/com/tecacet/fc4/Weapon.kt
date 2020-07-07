package com.tecacet.fc4

data class Weapon(val name : String,
                  val type : String,
                  var stats: IntArray,
                  var capacity : Int,
                  var extended : Int = capacity) {

    var accuracy = stats[0]
    var damage = stats[1]
    var range = stats[2]
    var fireRate = stats[3]
    var mobility = stats[4]

    fun resolveStats(stats: IntArray) {
        this.stats = stats
        accuracy = stats[0]
        damage = stats[1]
        range = stats[2]
        fireRate = stats[3]
        mobility = stats[4]
    }

    override fun toString() ="$name ($type)"
}