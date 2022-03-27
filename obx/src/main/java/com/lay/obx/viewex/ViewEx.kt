package com.lay.obx.viewex

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.flexbox.FlexboxLayout

val MATHPARENT = ViewGroup.LayoutParams.MATCH_PARENT
val WRAPCONTENT = ViewGroup.LayoutParams.WRAP_CONTENT

/**
 * 设置View的高度
 */
fun View.height(height: Int): View {
    val params = layoutParams ?: ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    params.height = height
    layoutParams = params
    return this
}

/**
 * 设置View的宽度
 */
fun View.width(width: Int): View {
    val params = layoutParams ?: ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    params.width = width
    layoutParams = params
    return this
}

fun View.widthAndHeight(width: Int, height: Int): View {
    val params = layoutParams ?: ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    params.width = width
    params.height = height
    layoutParams = params
    return this
}

/**
 * 设置View的margin
 * @param leftMargin 默认保留原来的
 * @param topMargin 默认是保留原来的
 * @param rightMargin 默认是保留原来的
 * @param bottomMargin 默认是保留原来的
 */
fun View.margin(
    leftMargin: Int = Int.MAX_VALUE,
    topMargin: Int = Int.MAX_VALUE,
    rightMargin: Int = Int.MAX_VALUE,
    bottomMargin: Int = Int.MAX_VALUE
): View {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    if (leftMargin != Int.MAX_VALUE)
        params.leftMargin = leftMargin
    if (topMargin != Int.MAX_VALUE)
        params.topMargin = topMargin
    if (rightMargin != Int.MAX_VALUE)
        params.rightMargin = rightMargin
    if (bottomMargin != Int.MAX_VALUE)
        params.bottomMargin = bottomMargin
    layoutParams = params
    return this
}

/**
 * 设置View的padding
 * @param leftPadding
 * @param topPadding
 * @param rightPadding
 * @param bottomPadding
 */
fun View.paddingDp(
    leftPadding: Int = 0,
    topPadding: Int = 0,
    rightPadding: Int = 0,
    bottomPadding: Int = 0
): View {
    setPadding(leftPadding.dp, topPadding.dp, rightPadding.dp, bottomPadding.dp)
    return this
}

fun View.paddingDp(
    verticalPadding: Int = 0,
    horizontalPadding: Int = 0,
): View {
    setPadding(horizontalPadding.dp, verticalPadding.dp, horizontalPadding.dp, verticalPadding.dp)
    return this
}

fun View.paddingDp(
    padding: Int = 0,
): View {
    setPadding(padding.dp, padding.dp, padding.dp, padding.dp)
    return this
}

fun View.linearParams(width : Int = WRAPCONTENT, height: Int = WRAPCONTENT, block: (LinearLayout.LayoutParams).() -> Unit) {
    layoutParams = LinearLayout.LayoutParams(width, height).apply(block)
}

fun View.frameParams(width : Int = WRAPCONTENT, height: Int = WRAPCONTENT, block: (FrameLayout.LayoutParams).() -> Unit) {
    layoutParams = FrameLayout.LayoutParams(width, height).apply(block)
}

fun View.flexParams(width : Int = WRAPCONTENT, height: Int = WRAPCONTENT, block: (FlexboxLayout.LayoutParams).() -> Unit) {
    layoutParams = FlexboxLayout.LayoutParams(width, height).apply(block)
}

fun View.constrainParams(width : Int = WRAPCONTENT, height: Int = WRAPCONTENT, block: (ConstraintLayout.LayoutParams).() -> Unit) {
    layoutParams = ConstraintLayout.LayoutParams(width, height).apply(block)
}


fun View.viewgroupParams(width : Int = WRAPCONTENT, height: Int = WRAPCONTENT, block: (ViewGroup.LayoutParams).() -> Unit) {
    layoutParams = ViewGroup.LayoutParams(width, height).apply(block)
}
