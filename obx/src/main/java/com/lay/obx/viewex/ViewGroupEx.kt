package com.lay.obx.viewex

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout


/**
 * 自定义控件
 */
inline fun <reified V : View> ViewGroup.CustomView(init: V.() -> Unit) {
    val clz = V::class.java
    val ct = clz.getDeclaredConstructor(Context::class.java)
    ct.isAccessible = true
    val view = ct.newInstance(context)
    addView((view).apply(init))
}