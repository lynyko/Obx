package com.lay.obx.viewex.view

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.lay.obx.viewex.initLayoutParams

inline fun <reified T : ViewGroup> T.RecyclerView(init: (androidx.recyclerview.widget.RecyclerView).() -> Unit) {
    addView(
        androidx.recyclerview.widget.RecyclerView(context)
        .apply {
            layoutParams = initLayoutParams(this@RecyclerView)
            layoutManager = LinearLayoutManager(context)
        }
        .apply(init))
}

inline fun <reified T : ViewGroup> T.HRecyclerView(init: (androidx.recyclerview.widget.RecyclerView).() -> Unit) {
    addView(
        androidx.recyclerview.widget.RecyclerView(context)
        .apply {
            layoutParams = initLayoutParams(this@HRecyclerView)
            layoutManager = LinearLayoutManager(context).apply{orientation = androidx.recyclerview.widget.RecyclerView.HORIZONTAL}
        }.apply(init))
}