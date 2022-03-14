package com.lay.obx.utils

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

object ShapeUtil {
    /**
     * 创建一个Shape - GradientDrawable
     *
     * @param strokeWidth - 沿边线厚度；无需传入-1  // px not dp
     * @param roundRadius - 圆角半径；无需传入-1    // px not dp
     * @param shape       - shape绘制类型(rectangle、oval等)；无需传入-1，将采用默认的GradientDrawable.RECTANGLE
     * @param strokeColor - 沿边线颜色；无需传入null/""
     * @param fillColor   - 内部填充颜色
     * @return
     */
    fun createShape(roundRadius: Int = -1,
                    strokeWidth: Int = -1,
                    strokeColor: Int? = null,
                    shape: Int = GradientDrawable.RECTANGLE,
                    fillColor: Int = Color.TRANSPARENT): GradientDrawable {
        val gd = GradientDrawable()
        gd.setColor(fillColor)
        gd.shape = shape
        if (-1 != roundRadius) {
            gd.cornerRadius = roundRadius.toFloat()
        }
        if (-1 != strokeWidth && null != strokeColor) {
            gd.setStroke(strokeWidth, strokeColor)
        }
        return gd
    }

    fun createShape(topLeftRadius: Float = 0F,
                    topRightRadius: Float = 0F,
                    bottomLeftRadius: Float = 0F,
                    bottomRightRadius: Float = 0F,
                    strokeWidth: Int = -1,
                    strokeColor: Int? = null,
                    shape: Int = GradientDrawable.RECTANGLE,
                    fillColor: Int = Color.TRANSPARENT): GradientDrawable {
        val gd = GradientDrawable()
        gd.setColor(fillColor)
        gd.shape = shape
        val radius = floatArrayOf(topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius)
        gd.cornerRadii = radius
        if (-1 != strokeWidth && null != strokeColor) {
            gd.setStroke(strokeWidth, strokeColor)
        }
        return gd
    }
}
