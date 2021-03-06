package com.lay.obx.viewex.view

import android.view.ViewGroup
import android.widget.EditText
import com.lay.obx.viewex.FlexboxLayout


fun ViewGroup.EditText(init: (EditText).() -> Unit) {
    addView(EditText(context)
        .apply(init))
}

fun ViewGroup.EditText(string: CharSequence, init: (EditText).() -> Unit) {
    addView(EditText(context).apply {
        setText(string)
        init()
    })
}