package com.lay.obx

import androidx.lifecycle.Lifecycle

internal class ObxManager private constructor(){
    private val listenerMap = HashMap<Long, ArrayList<OnDataChangeListener>>()
    companion object{
        val instance = ObxManager()
    }

    fun <T> subscribe(obx : Obx<T>, listener: OnDataChangeListener){
        var listenerList = listenerMap[obx.code]
        if(listenerList == null){
            listenerList = ArrayList()
            listenerMap[obx.code] = listenerList
        }
        listenerList.add(listener)
    }

    fun <T> update(obx : Obx<T>){
        var listenerList = listenerMap[obx.code]
        listenerList?.let {
            it.forEach {
                it.update()
            }
        }
    }

    fun clear(any : Any){
        listenerMap.remove(any)
    }

    fun remove(listener: OnDataChangeListener) : Boolean{
        listenerMap.forEach {
            if(it.value.contains(listener)){
                it.value.remove(listener)
                println("remove success")
                return true
            }
        }
        println("remove failed")
        return false
    }
}