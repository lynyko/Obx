package com.lay.obx.viewex

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout


/**
 * LinearLayout
 */
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

/**
 * FrameLayout
 */
fun ViewGroup.FrameLayout(init: (FrameLayout).() -> Unit) {
    addView(FrameLayout(context).apply(init))
}

/**
 * ConstraintLayout
 */
fun ViewGroup.ConstraintLayout(init: (ConstraintLayout).() -> Unit) {
    addView(ConstraintLayout(context).apply(init))
}

/**
 * 自定义控件
 */
inline fun <reified V : View> ViewGroup.CustomView(init: V.() -> Unit) {
    val clz = V::class.java
    val view = clz.newInstance()
    val field = clz.getDeclaredField("mContext")
    field.isAccessible = true
    field.set(view, context)
    addView((view).apply(init))
}

/**
 * Button
 */
fun ViewGroup.Button(init: (Button).() -> Unit) {
    addView(Button(context).apply(init))
}

fun ViewGroup.Button(string: CharSequence, init: (Button).() -> Unit) {
    addView(Button(context).apply { text = string }.apply(init))
}

/**
 * EditText
 */
fun ViewGroup.EditText(init: (EditText).() -> Unit) {
    addView(EditText(context).apply(init))
}

fun ViewGroup.EditText(string: CharSequence, init: (EditText).() -> Unit) {
    addView(EditText(context).apply {
        setText(string)
        init()
    })
}

/**
 * ImageView
 */
fun ViewGroup.ImageView(resId: Int, init: ImageView.() -> Unit) {
    addView(ImageView(context).apply {
        setImageResource(resId)
        init()
    })
}

fun ViewGroup.ImageView(drawable: Drawable, init: ImageView.() -> Unit) {
    addView(ImageView(context).apply {
        setImageDrawable(drawable)
        init()
    })
}

fun ViewGroup.ImageView(bitmap: Bitmap, init: ImageView.() -> Unit) {
    addView(ImageView(context).apply {
        setImageBitmap(bitmap)
        init()
    })
}