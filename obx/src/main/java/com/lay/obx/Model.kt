package com.lay.obx

import java.lang.StringBuilder
import kotlin.Pair
import kotlin.Triple

data class ObxPair<A : Any, B : Any>(var first: A? = null, var second: B? = null) {
    override fun toString(): String = "($first, $second)"
}

data class ObxTriple<A : Any, B : Any, C : Any>(var first: A? = null, var second: B? = null, var third: C? = null) {
    override fun toString(): String = "($first, $second, $third)"
}

data class ObxMutil<T : Any>(var values : ArrayList<out T> = ArrayList()) {
    override fun toString() : String {
        val sb = StringBuilder()
        values.forEach {
            sb.append("$it,")
        }
        if(sb.isNotEmpty()){
            sb.deleteCharAt(sb.lastIndexOf(','))
        }
        return sb.toString()
    }
}