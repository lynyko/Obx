package com.lay.obx

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnDetach
import androidx.core.widget.doAfterTextChanged

class SecondActivity : AppCompatActivity() {


    var isCheck : Boolean = false

    private val switchObx = isCheck.obx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn).run{
            setOnClickListener {
                switchObx.update{
                    this.value = !isCheck
                }
            }
        }
        switchObx.subscribe{
            findViewById<Button>(R.id.btn).text = "${switchObx.value}"
        }.init().bind(this)
    }
}