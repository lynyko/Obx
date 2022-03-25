package com.lay.obx.second

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lay.obx.Model
import com.lay.obx.findObx
import com.lay.obx.init
import com.lay.obx.subscribe
import com.lay.obx.viewex.MATHPARENT
import com.lay.obx.viewex.initLayoutParams
import com.lay.obx.viewex.view.Button
import com.lay.obx.viewex.view.RecyclerView
import com.lay.obx.viewex.width

class PairButtonComponents(context: Context, attributeSet: AttributeSet) : LinearLayout(context) {
    init {
        layoutParams = initLayoutParams(this)
        orientation = VERTICAL
        val obx = context.findObx(Int::class.java)
        Button("left") {
            obx?.subscribe{
                text = "${it.value}"
            }?.init()
            textSize = 20F
            setTextColor(Color.RED)
        }

        val list = ArrayList<Int>()
        val myAdapter = MyAdapter(context, list)
        RecyclerView {
            obx?.subscribe{
                list.add(it.value!!)
                myAdapter.notifyDataSetChanged()
            }?.init()
            width(MATHPARENT)
            adapter = myAdapter
        }

    }

    private class MyAdapter(var context: Context, var list : ArrayList<Int>) : RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val tv = TextView(context)
            return MyViewHolder(tv)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            (holder.itemView as TextView).text = "${list[position]}"
        }

        override fun getItemCount() = list.size
    }

    private class MyViewHolder(view : View) : RecyclerView.ViewHolder(view)
}