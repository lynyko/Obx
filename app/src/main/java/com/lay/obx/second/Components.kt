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
import com.lay.obx.viewex.*
import com.lay.obx.viewex.view.Button
import com.lay.obx.viewex.view.RecyclerView

class PairButtonComponents(context: Context, attributeSet: AttributeSet? = null) : LinearLayout(context, attributeSet) {
    init {
        orientation = VERTICAL
        val obx = context.findObx(Int::class.java)
        linearParams {
            width = MATHPARENT
        }
        val list = ArrayList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        val myAdapter = MyAdapter(context, list)
        RecyclerView {
            linearParams {
                width = MATHPARENT
            }
            obx?.subscribe{
                list.add(it.value!!)
                myAdapter.notifyDataSetChanged()
            }?.init{
                list.clear()
            }
            adapter = myAdapter
        }

    }

    private class MyAdapter(var context: Context, var list : ArrayList<Int>) : RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val tv = TextView(context).apply {
                gravity = Gravity.CENTER
                viewgroupParams {
                    width = MATHPARENT
                    height = 40.dp
                }
            }
            return MyViewHolder(tv)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            (holder.itemView as TextView).text = "${list[position]}"
        }

        override fun getItemCount() = list.size
    }

    private class MyViewHolder(view : View) : RecyclerView.ViewHolder(view)
}