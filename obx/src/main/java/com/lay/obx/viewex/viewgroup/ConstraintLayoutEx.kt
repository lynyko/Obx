package com.lay.obx.viewex

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout

fun ViewGroup.ConstraintLayout(init: (ConstraintLayout).() -> Unit) {
    addView(ConstraintLayout(context).apply(init))
}

val View.ConstraintLayoutParams: ConstraintLayout.LayoutParams
    get() = ConstraintLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )