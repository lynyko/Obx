package com.lay.obx.second

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lay.obx.*
import com.lay.obx.viewex.children
import com.lay.obx.viewex.warpContent
import com.lay.obx.viewex.widthAndHeight

class SecondActivity : AppCompatActivity() {

    private val switchObx by lazy {
        false.obx("switchObx").bind(this)
    }

    private val modelObx = obx<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        modelObx.value = Model("111")
        modelObx.bind(this)
        findViewById<Button>(R.id.btn).run{
            setOnClickListener {
                switchObx.update{
                    value = !value!!
                }
                modelObx.update {
                    value!!.text = value!!.text + "1"
                }
            }
        }
        switchObx.subscribe{
            findViewById<Button>(R.id.btn).text = "${switchObx.value}"
        }.init()

        findObx<Boolean>("switchObx1")?.subscribe{
            Toast.makeText(this, "${it.value}", Toast.LENGTH_SHORT).show()
        }

        findObx(Model::class.java)?.subscribe{
            Toast.makeText(this, "${it.value?.text}", Toast.LENGTH_SHORT).show()
        }?.init()
    }
}

class TestView(context: Context, attributeSet: AttributeSet? = null) : LinearLayout(context){
    init{
        orientation = HORIZONTAL
        widthAndHeight(warpContent, warpContent)
        layoutDirection = LAYOUT_DIRECTION_RTL
        children(
            TextView(context).apply {
                layoutParams = LayoutParams(warpContent, warpContent)
                text = "123"
                textSize = 20F
                setTextColor(Color.RED)
            },
            TextView(context).apply {
                layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            },
            TextView(context).apply {
                text = "789"
            },
        )
    }
}

class TestView2(context: Context) : LinearLayout(context){
    init{
        orientation = VERTICAL
        gravity = Gravity.LEFT
        children(
            TextView(context).apply {
                layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                width = ViewGroup.LayoutParams.WRAP_CONTENT
                text = "111"
            },
            TextView(context).apply {
                layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                text = "451223236"
            },
            TextView(context).apply {
                layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                text = "7232323189"
            },
            TestView(context)
        )
    }
}