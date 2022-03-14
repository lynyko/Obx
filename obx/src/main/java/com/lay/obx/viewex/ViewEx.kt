package com.lay.obx.viewex

import android.animation.Animator
import android.animation.IntEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.lay.obx.utils.ColorStateListHelper
import com.lay.obx.utils.ShapeUtil

val warpContent = ViewGroup.LayoutParams.WRAP_CONTENT
val mathParent = ViewGroup.LayoutParams.MATCH_PARENT

var TextView.textSizeSp : Float
    get() {
        return this.textSize
    }
    set(value) {
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, value)
    }


/**
 * 设置子View
 */
fun ViewGroup.children(vararg children : View) : ViewGroup{
    children.forEach {
        this.addView(it)
    }
    return this
}

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
 * 设置View高度，限制在min和max范围之内
 * @param h
 * @param min 最小高度
 * @param max 最大高度
 */
fun View.limitHeight(h: Int, min: Int, max: Int): View {
    val params = layoutParams ?: ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    when {
        h < min -> params.height = min
        h > max -> params.height = max
        else -> params.height = h
    }
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

/**
 * 设置View宽度，限制在min和max范围之内
 * @param w
 * @param min 最小宽度
 * @param max 最大宽度
 */
fun View.limitWidth(w: Int, min: Int, max: Int): View {
    val params = layoutParams ?: ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    when {
        w < min -> params.width = min
        w > max -> params.width = max
        else -> params.width = w
    }
    layoutParams = params
    return this
}

/**
 * 设置View的宽度和高度
 * @param width 要设置的宽度
 * @param height 要设置的高度
 */
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

/**
 * 设置宽度，带有过渡动画
 * @param targetValue 目标宽度
 * @param duration 时长
 * @param action 可选行为
 */
fun View.animateWidth(
    targetValue: Int, duration: Long = 400, listener: Animator.AnimatorListener? = null,
    action: ((Float) -> Unit)? = null
) {
    post {
        ValueAnimator.ofInt(width, targetValue).apply {
            addUpdateListener {
                width(it.animatedValue as Int)
                action?.invoke((it.animatedFraction))
            }
            if (listener != null) addListener(listener)
            setDuration(duration)
            start()
        }
    }
}

/**
 * 设置高度，带有过渡动画
 * @param targetValue 目标高度
 * @param duration 时长
 * @param action 可选行为
 */
fun View.animateHeight(
    targetValue: Int,
    duration: Long = 400,
    listener: Animator.AnimatorListener? = null,
    action: ((Float) -> Unit)? = null
) {
    post {
        ValueAnimator.ofInt(height, targetValue).apply {
            addUpdateListener {
                height(it.animatedValue as Int)
                action?.invoke((it.animatedFraction))
            }
            if (listener != null) addListener(listener)
            setDuration(duration)
            start()
        }
    }
}

/**
 * 设置宽度和高度，带有过渡动画
 * @param targetWidth 目标宽度
 * @param targetHeight 目标高度
 * @param duration 时长
 * @param action 可选行为
 */
fun View.animateWidthAndHeight(
    targetWidth: Int,
    targetHeight: Int,
    duration: Long = 400,
    listener: Animator.AnimatorListener? = null,
    action: ((Float) -> Unit)? = null
) {
    post {
        val startHeight = height
        val evaluator = IntEvaluator()
        ValueAnimator.ofInt(width, targetWidth).apply {
            addUpdateListener {
                widthAndHeight(
                    it.animatedValue as Int,
                    evaluator.evaluate(it.animatedFraction, startHeight, targetHeight)
                )
                action?.invoke((it.animatedFraction))
            }
            if (listener != null) addListener(listener)
            setDuration(duration)
            start()
        }
    }
}

//-----------------------设置背景--开始--------------------------

data class ViewBackgroundSetting(
    var selectRoundRadius: Int = -1,
    var selectStrokeWidth: Int = -1,
    var selectStrokeColor: Int? = null,
    var selectShape: Int = GradientDrawable.RECTANGLE,
    var selectFillColor: Int = Color.TRANSPARENT,
    var unSelectRoundRadius: Int = -1,
    var unSelectStrokeWidth: Int = -1,
    var unSelectStrokeColor: Int? = null,
    var unSelectShape: Int = GradientDrawable.RECTANGLE,
    var unSelectFillColor: Int = Color.TRANSPARENT,
)

fun View.setBackgroundIntricacy(
    isAddPressState: Boolean = false,
    settingBlock: ViewBackgroundSetting.() -> Unit
) {
    val setting = ViewBackgroundSetting().apply {
        settingBlock()
    }
    val selectDrawable = ShapeUtil.createShape(
        setting.selectRoundRadius,
        setting.selectStrokeWidth,
        setting.selectStrokeColor,
        setting.selectShape,
        setting.selectFillColor,
    )
    val unSelectDrawable = ShapeUtil.createShape(
        setting.unSelectRoundRadius,
        setting.unSelectStrokeWidth,
        setting.unSelectStrokeColor,
        setting.unSelectShape,
        setting.unSelectFillColor,
    )
    setSelectBgWithDrawable(selectDrawable, unSelectDrawable, isAddPressState)
}

fun View.setBackgroundByDrawable(
    roundRadius: Int = -1,
    strokeWidth: Int = -1,
    strokeColor: Int? = null,
    shape: Int = GradientDrawable.RECTANGLE,
    fillColor: Int = Color.TRANSPARENT
) {
    val gradientDrawable = ShapeUtil.createShape(
        roundRadius,
        strokeWidth,
        strokeColor,
        shape,
        fillColor
    )
    background = gradientDrawable
}

fun View.setBackgroundByDrawable(
    topLeftRadius: Float = 0F,
    topRightRadius: Float = 0F,
    bottomLeftRadius: Float = 0F,
    bottomRightRadius: Float = 0F,
    strokeWidth: Int = -1,
    strokeColor: Int? = null,
    shape: Int = GradientDrawable.RECTANGLE,
    fillColor: Int = Color.TRANSPARENT
) {
    val gradientDrawable = ShapeUtil.createShape(
        topLeftRadius,
        topRightRadius,
        bottomLeftRadius,
        bottomRightRadius,
        strokeWidth,
        strokeColor,
        shape,
        fillColor
    )
    background = gradientDrawable
}

fun View.setSelectBgColor(selectColor: Int, unSelectColor: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        backgroundTintList =
            ColorStateListHelper.createSimpleSelectedStateList(selectColor, unSelectColor)
    }
}

fun View.setSelectFgColor(selectColor: Int, unSelectColor: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foregroundTintList =
            ColorStateListHelper.createSimpleSelectedStateList(selectColor, unSelectColor)
    }
}

fun View.setSelectBgColorWithCorners(selectColor: Int, unSelectColor: Int, corners: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        backgroundTintList =
            ColorStateListHelper.createSimpleSelectedStateList(selectColor, unSelectColor)
    }
}

fun View.setSelectFgColorWithCorners(selectColor: Int, unSelectColor: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foregroundTintList =
            ColorStateListHelper.createSimpleSelectedStateList(selectColor, unSelectColor)
    }
}

fun View.setSelectBgWithDrawableResID(
    selectDrawableResID: Int,
    unSelectDrawableResID: Int,
    isAddPressState: Boolean = false
) {
    background = createStateListDrawableByResID(
        selectDrawableResID,
        unSelectDrawableResID,
        isAddPressState,
        resources
    )
}

fun View.setSelectBgWithDrawable(
    selectDrawable: Drawable,
    unSelectDrawable: Drawable,
    isAddPressState: Boolean = false
) {
    background = createStateListDrawable(selectDrawable, unSelectDrawable, isAddPressState)
}

fun ImageView.setSelectFgWithDrawableResID(
    selectDrawableResID: Int,
    unSelectDrawableResID: Int,
    isAddPressState: Boolean = false
) {
    setImageDrawable(
        createStateListDrawableByResID(
            selectDrawableResID,
            unSelectDrawableResID,
            isAddPressState,
            resources
        )
    )
}

fun ImageView.setSelectFgWithDrawable(
    selectDrawable: Drawable,
    unSelectDrawable: Drawable,
    isAddPressState: Boolean = false
) {
    setImageDrawable(createStateListDrawable(selectDrawable, unSelectDrawable, isAddPressState))
}

fun createStateListDrawableByResID(
    selectDrawableResID: Int,
    unSelectDrawableResID: Int,
    isAddPressState: Boolean = false,
    resources: Resources = Resources.getSystem()
): StateListDrawable {
    return createStateListDrawable(
        ResourcesCompat.getDrawable(resources, selectDrawableResID, null)!!,
        ResourcesCompat.getDrawable(resources, unSelectDrawableResID, null)!!,
        isAddPressState
    )
}

fun createStateListDrawable(
    selectDrawable: Drawable,
    unSelectDrawable: Drawable,
    isAddPressState: Boolean = false
): StateListDrawable {
    return StateListDrawable().apply {
        addState(intArrayOf(android.R.attr.state_selected), selectDrawable)
        addState(intArrayOf(), unSelectDrawable)
        addState(intArrayOf(-android.R.attr.state_selected), unSelectDrawable)
        if (isAddPressState) {
            addState(intArrayOf(android.R.attr.state_pressed), selectDrawable)
        }
    }
}

//-----------------------设置背景--结束--------------------------