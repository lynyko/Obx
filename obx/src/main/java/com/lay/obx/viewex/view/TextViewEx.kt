package com.lay.obx.viewex

import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

inline fun <reified T : ViewGroup> T.TextView(init: (TextView).() -> Unit) {
    addView(TextView(context)
        .apply(init))
}

fun ViewGroup.TextView(string: CharSequence, init: (TextView).() -> Unit) {
    addView(TextView(context).apply {
        text = string
    }.apply(init))
}

var TextView.textColor: Int
    get() = this.currentTextColor
    set(value) {
        this.setTextColor(value)
    }

var TextView.textSizeSp: Float
    get() {
        return this.textSize
    }
    set(value) {
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, value)
    }