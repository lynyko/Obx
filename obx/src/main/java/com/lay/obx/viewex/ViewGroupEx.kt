package com.lay.obx.viewex

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.AttributeSet
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
    val ct = clz.getDeclaredConstructor(Context::class.java, AttributeSet::class.java)
    ct.isAccessible = true
    val view = ct.newInstance(context, null)
    addView((view).apply {
        init()
    })
}

fun ViewGroup.HorizontalLayout(init: (LinearLayout).() -> Unit) {
    addView(LinearLayout(context)
        .apply {
            orientation = LinearLayout.HORIZONTAL
        }.apply(init))
}

fun ViewGroup.VerticalLayout(init: (LinearLayout).() -> Unit) {
    addView(
        LinearLayout(context)
            .apply {
                orientation = LinearLayout.VERTICAL
            }.apply(init)
    )
}

fun ViewGroup.FrameLayout(init: (FrameLayout).() -> Unit) {
    addView(FrameLayout(context)
        .apply(init))
}

fun ViewGroup.FlexboxLayout(init: (FlexboxLayout).() -> Unit) {
    addView(FlexboxLayout(context)
        .apply(init))
}

fun ViewGroup.ConstraintLayout(init: (ConstraintLayout).() -> Unit) {
    addView(ConstraintLayout(context)
        .apply(init))
}

fun View.lp(){
    val lp =  when(this.parent){
        is LinearLayout -> LinearLayout.LayoutParams(WRAPCONTENT, WRAPCONTENT)
        else -> ViewGroup.LayoutParams(WRAPCONTENT, WRAPCONTENT)
    }
}