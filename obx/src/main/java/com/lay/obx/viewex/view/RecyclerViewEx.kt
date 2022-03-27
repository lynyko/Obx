package com.lay.obx.viewex.view

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

inline fun <reified T : ViewGroup> T.RecyclerView(init: (androidx.recyclerview.widget.RecyclerView).() -> Unit) {
    addView(
        androidx.recyclerview.widget.RecyclerView(context)
        .apply {
            layoutManager = LinearLayoutManager(context)
        }
        .apply(init))
}

inline fun <reified T : ViewGroup> T.HRecyclerView(init: (androidx.recyclerview.widget.RecyclerView).() -> Unit) {
    addView(
        androidx.recyclerview.widget.RecyclerView(context)
        .apply {
            layoutManager = LinearLayoutManager(context).apply{orientation = androidx.recyclerview.widget.RecyclerView.HORIZONTAL}
        }.apply(init))
}