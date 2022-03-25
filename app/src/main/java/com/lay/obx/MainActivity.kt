package com.lay.obx

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import com.lay.obx.viewex.*
import com.lay.obx.viewex.view.Button

class MainActivity : AppCompatActivity() {

    val textObx = 1.obx
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textObx.bind(this)
        setContentView(R.layout.activity_main)
    }
}

class ContentView(context: Context, attributes: AttributeSet? = null) : LinearLayout(context, attributes){
    init {
        orientation = VERTICAL
        widthAndHeight(MATHPARENT, MATHPARENT)
        gravity = Gravity.CENTER
        val textObx = context.findObx(Int::class.java)
        TextView("1"){
            gravity = Gravity.CENTER
            textObx?.subscribe{
                text = "${it.value}"
            }?.init()
        }
        Button {
            width(200.dp)
            text = "点击"
            textSize = 15F
            setOnClickListener {
                textObx?.update {
                    value = value!! + 1
                }
            }
        }
    }

}