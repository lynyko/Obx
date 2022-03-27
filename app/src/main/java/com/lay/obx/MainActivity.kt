package com.lay.obx

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import com.lay.obx.second.PairButtonComponents
import com.lay.obx.viewex.*
import com.lay.obx.viewex.view.Button

class MainActivity : AppCompatActivity() {

    val textObx = 1.obx
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textObx.bind(this)
        setContentView(ContentView(this))
    }
}

class ContentView(context: Context, attributes: AttributeSet? = null) : LinearLayout(context, attributes){
    init {
        orientation = VERTICAL
        linearParams(MATHPARENT, MATHPARENT){
        }
        val textObx = context.findObx(Int::class.java)
        HorizontalLayout {
            linearParams {
                width = MATHPARENT
            }
            TextView("1"){
                linearParams {
                    setBackgroundColor(Color.RED)
                    weight = 1F
                    height = 30.dp
                }
                textColor = Color.WHITE
                gravity = Gravity.CENTER
                textObx?.subscribe{
                    text = "${it.value}"
                }?.init{}
            }
            TextView("1"){
                linearParams {
                    setBackgroundColor(Color.BLUE)
                    weight = 0.5F
                    height = 30.dp
                }
                gravity = Gravity.CENTER
                textColor = Color.WHITE
                textObx?.subscribe{
                    text = "${it.value}"
                }?.init{}
            }
        }
        Button {
            linearParams {
                width = 200.dp
                gravity = Gravity.CENTER_HORIZONTAL
            }
            gravity = Gravity.CENTER
            text = "点击"
            textSize = 15F
            setOnClickListener {
                textObx?.update {
                    value = value!! + 1
                }
            }
        }
        CustomView<PairButtonComponents> {
            linearParams {
                width = MATHPARENT
            }
        }
    }

}