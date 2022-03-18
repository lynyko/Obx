package com.lay.obx.viewex.view

import android.view.ViewGroup
import android.widget.EditText
import com.lay.obx.viewex.FlexboxLayout
import com.lay.obx.viewex.initLayoutParams


fun ViewGroup.EditText(init: (EditText).() -> Unit) {
    addView(EditText(context)
        .apply { layoutParams = initLayoutParams(this@EditText) }
        .apply(init))
}

fun ViewGroup.EditText(string: CharSequence, init: (EditText).() -> Unit) {
    addView(EditText(context).apply {
        layoutParams = initLayoutParams(this@EditText)
        setText(string)
        init()
    })
}