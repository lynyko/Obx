package com.lay.obx

data class Obx<T>(var value : T, internal val code : Long = (Math.random() * 100000000).toLong())