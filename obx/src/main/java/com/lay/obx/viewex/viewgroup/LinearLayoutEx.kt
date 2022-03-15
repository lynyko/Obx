package com.lay.obx.viewex

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

fun ViewGroup.HorizontalLayout(init: (LinearLayout).() -> Unit) {
    addView(LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
    }.apply(init))
}

fun ViewGroup.VerticalLayout(init: (LinearLayout).() -> Unit) {
    addView(LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
    }.apply(init))
}

val View.linearLayoutParams: LinearLayout.LayoutParams
    get() = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )