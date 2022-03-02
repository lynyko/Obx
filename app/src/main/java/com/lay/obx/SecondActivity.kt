package com.lay.obx

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnDetach
import androidx.core.widget.doAfterTextChanged

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn).run{
            setOnClickListener {
                MainActivity.model.update{
                    text = "hello world"
                }
            }
        }
        MainActivity.model.text = "hello"
        MainActivity.model.subscribe{
            findViewById<Button>(R.id.btn).text = MainActivity.model.text
        }.init().bind(this)
    }
}