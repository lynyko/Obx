package com.lay.obx.second

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.lay.obx.*
import com.lay.obx.viewex.*

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

        ItemView(this)
    }
}

private class ItemView(context: Context, attributeSet: AttributeSet? = null) : LinearLayout(context){
    init {
        paddingDp(15)
        TextView("应急响应名称") {
            textColor = Color.parseColor("#0F1114")
            textSizeSp = 15F
            (layoutParams as LayoutParams).weight = 1F
        }
        TextView {
            hint = "请输入"
            textColor = Color.parseColor("#0F1114")
            textSizeSp = 15F
        }
    }
}