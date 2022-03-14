package com.lay.obx.viewex

import android.content.res.Resources
import android.util.TypedValue

private fun dp2px(value: Float, res: Resources = Resources.getSystem()): Float =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, value, res.displayMetrics
    )

val Int.dp: Int
    get() = dp2px(this.toFloat()).toInt()