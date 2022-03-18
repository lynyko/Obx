package com.lay.obx.viewex

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.flexbox.FlexboxLayout


/**
 * 自定义控件
 */
inline fun <reified V : View> ViewGroup.CustomView(init: V.() -> Unit) {
    val clz = V::class.java
    val ct = clz.getDeclaredConstructor(Context::class.java)
    ct.isAccessible = true
    val view = ct.newInstance(context)
    addView((view).apply {
        layoutParams = initLayoutParams(this@CustomView)
        init()
    })
}

fun ViewGroup.HorizontalLayout(init: (LinearLayout).() -> Unit) {
    addView(LinearLayout(context)
        .apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = initLayoutParams(this@HorizontalLayout)
        }.apply(init))
}

fun ViewGroup.VerticalLayout(init: (LinearLayout).() -> Unit) {
    addView(
        LinearLayout(context)
            .apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = initLayoutParams(this@VerticalLayout)
            }.apply(init)
    )
}

fun ViewGroup.FrameLayout(init: (FrameLayout).() -> Unit) {
    addView(FrameLayout(context)
        .apply { layoutParams = initLayoutParams(this@FrameLayout) }
        .apply(init))
}

fun ViewGroup.FlexboxLayout(init: (FlexboxLayout).() -> Unit) {
    addView(FlexboxLayout(context)
        .apply { layoutParams = initLayoutParams(this@FlexboxLayout) }
        .apply(init))
}

fun ViewGroup.ConstraintLayout(init: (ConstraintLayout).() -> Unit) {
    addView(ConstraintLayout(context)
        .apply { layoutParams = initLayoutParams(this@ConstraintLayout) }
        .apply(init))
}

inline fun <reified T : ViewGroup> initLayoutParams(parent: T): ViewGroup.LayoutParams {
    return when (parent::class.java) {
        LinearLayout::class.java -> LinearLayout.LayoutParams(WRAPCONTENT, WRAPCONTENT)
        FrameLayout::class.java -> FrameLayout.LayoutParams(WRAPCONTENT, WRAPCONTENT)
        ConstraintLayout::class.java -> ConstraintLayout.LayoutParams(WRAPCONTENT, WRAPCONTENT)
        FlexboxLayout::class.java -> FlexboxLayout.LayoutParams(WRAPCONTENT, WRAPCONTENT)
        else -> ViewGroup.LayoutParams(WRAPCONTENT, WRAPCONTENT)
    }
}