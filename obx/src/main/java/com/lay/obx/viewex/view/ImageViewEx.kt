package com.lay.obx.viewex.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.ImageView


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