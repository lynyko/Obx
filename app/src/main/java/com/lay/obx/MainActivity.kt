package com.lay.obx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lay.obx.*

class MainActivity : AppCompatActivity() {
    companion object{
        val model = Model("点击")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn).run{
            text = model.text
            setOnClickListener {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }
        }
        model.subscribe{
            findViewById<Button>(R.id.btn).text = model.text
        }

        val s = "123".obx
        println("s:${s.value}")
        s.subscribe{
            println("s2:${s.value}")
        }
        s.update {
            value = "113"
        }
    }
}