package com.lay.obx.viewex.view

import android.view.ViewGroup
import android.widget.Button


fun ViewGroup.Button(init: (Button).() -> Unit) {
    addView(Button(context).apply(init))
}

fun ViewGroup.Button(string: CharSequence, init: (Button).() -> Unit) {
    addView(Button(context).apply { text = string }.apply(init))
}