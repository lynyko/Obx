package com.lay.obx.viewex

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

/**
 * FrameLayout
 */
fun ViewGroup.FrameLayout(init: (FrameLayout).() -> Unit) {
    addView(FrameLayout(context).apply(init))
}


val View.frameLayoutParams: LinearLayout.LayoutParams
    get() = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )