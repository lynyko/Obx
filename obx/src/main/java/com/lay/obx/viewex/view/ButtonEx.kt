package com.lay.obx.viewex.view

import android.view.ViewGroup
import android.widget.Button
import com.lay.obx.viewex.initLayoutParams


fun ViewGroup.Button(init: (Button).() -> Unit) {
    addView(Button(context)
        .apply { layoutParams = initLayoutParams(this@Button) }
        .apply(init))
}

fun ViewGroup.Button(string: CharSequence, init: (Button).() -> Unit) {
    addView(Button(context)
        .apply {
            layoutParams = initLayoutParams(this@Button)
            text = string
        }.apply(init)
    )
}