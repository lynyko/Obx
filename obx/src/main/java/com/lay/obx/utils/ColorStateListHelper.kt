package com.lay.obx.utils

import android.content.res.ColorStateList

class ColorStateListHelper {
    companion object {
        @JvmStatic
        fun createSimpleSelectedStateList(selectedColor: Int, unSelectedColor: Int) =
            ColorStateList(
                arrayOf(
                    intArrayOf(android.R.attr.state_selected),
                    intArrayOf(-android.R.attr.state_selected)
                ), intArrayOf(
                    selectedColor, unSelectedColor
                )
            )
    }
}