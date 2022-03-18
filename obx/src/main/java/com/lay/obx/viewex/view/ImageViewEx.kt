package com.lay.obx.viewex.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.ImageView
import com.lay.obx.viewex.TextView
import com.lay.obx.viewex.initLayoutParams


fun ViewGroup.ImageView(resId: Int, init: ImageView.() -> Unit) {
    addView(ImageView(context).apply {
        layoutParams = initLayoutParams(this@ImageView)
        setImageResource(resId)
        init()
    })
}

fun ViewGroup.ImageView(drawable: Drawable, init: ImageView.() -> Unit) {
    addView(ImageView(context).apply {
        layoutParams = initLayoutParams(this@ImageView)
        setImageDrawable(drawable)
        init()
    })
}

fun ViewGroup.ImageView(bitmap: Bitmap, init: ImageView.() -> Unit) {
    addView(ImageView(context).apply {
        layoutParams = initLayoutParams(this@ImageView)
        setImageBitmap(bitmap)
        init()
    })
}