package com.lay.obx.viewex

import android.graphics.Color

private fun int2Color(color: Int): Int {
    val alpha = color and -0x1000000 ushr 24
    val red = color and 0x00ff0000 shr 16
    val green = color and 0x0000ff00 shr 8
    val blue = color and 0x000000ff
    return Color.argb(alpha, red, green, blue)
}

val Int.rgb: Int
    get() {
        val color = this and 0xFF shl 24
        return int2Color(color)
    }

val Int.argb: Int
    get() = int2Color(this)