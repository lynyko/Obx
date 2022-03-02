package com.lay.obx

import androidx.lifecycle.Lifecycle

internal class ObxManager private constructor(){
    private val listenerMap = HashMap<Int, ArrayList<OnDataChangeListener>>()
    companion object{
        val instance = ObxManager()
    }

    fun createObserve(any : Any){
        var listenerList = listenerMap[any.hashCode()]
        if(listenerList == null){
            listenerList = ArrayList()
            listenerMap[any.hashCode()] = listenerList
        }
    }

    fun subscribe(any : Any, listener: OnDataChangeListener){
        var listenerList = listenerMap[any.hashCode()]
        if(listenerList == null){
            listenerList = ArrayList()
            listenerMap[any.hashCode()] = listenerList
        }
        listenerList.add(listener)
    }

    fun update(any : Any){
        var listenerList = listenerMap[any.hashCode()]
        listenerList?.let {
            it.forEach {
                it.update()
            }
        }
    }

    fun clear(any : Any){
        listenerMap.remove(any.hashCode())
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