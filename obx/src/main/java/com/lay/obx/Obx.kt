package com.lay.obx

private var privateCode = 1L
data class Obx<T>(
    var value : T? = null,
    var key : String = "",
    internal val code : Long = privateCode++)