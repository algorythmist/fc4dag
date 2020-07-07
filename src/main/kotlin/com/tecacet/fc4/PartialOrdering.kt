package com.tecacet.fc4

interface PartialOrdering<T> {

    /**
     * @return -1 if t1 < t2. 1 if t1 > t2. 0 if not comparable
     */
    fun compare(t1: T, t2: T): Int
}

operator fun IntArray.minus(other: IntArray): IntArray {
    if (this.size != other.size) {
        throw IllegalArgumentException("Arrays must have the same size")
    }
    return (other.indices).map { i -> this[i] - other[i] }.toIntArray()
}

/**
 * t1 > t2 only if t1[i] >= t2[i] and t1[j] > t2[j] for some j
 */
class ArrayPartialOrdering : PartialOrdering<IntArray> {

    override fun compare(t1: IntArray, t2: IntArray): Int {
        var sofar = 0
        val diff = t1 - t2
        diff.forEach { i ->
            if (sofar == 0) {
                sofar = i
            } else if (sofar > 0 && i < 0) {
                return 0 //not comparable
            } else if (sofar < 0 && i > 0) {
                return 0
            }
        }
        return sofar
    }
}

class InducedPartialOrdering<T>(val mapper: (T) -> IntArray) : PartialOrdering<T> {
    private val arrayPartialOrdering = ArrayPartialOrdering()
    override fun compare(t1: T, t2: T): Int {
        return arrayPartialOrdering.compare(mapper(t1), mapper(t2))
    }

}
