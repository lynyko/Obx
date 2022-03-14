package com.lay.obx.second

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import com.lay.obx.findObx

class PairButtonComponents(context: Context, attributeSet: AttributeSet) : LinearLayout(context) {
    init {
        context.findObx(String::class.java)
        gravity = Gravity.CENTER
        addView(Button(context).apply{
            text = "left"
            textSize = 20F
            setTextColor(Color.RED)
        })
        addView(Button(context).apply{
            text = "right"
        })
    }
}