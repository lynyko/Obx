package com.lay.obx

import android.view.View
import androidx.core.view.doOnDetach
import androidx.lifecycle.LifecycleOwner

fun <T : Any> T.update(init : T.() -> Unit){
    this.init()
    ObxManager.instance.update(this as Any)
}

fun Any.subscribe(listener: OnDataChangeListener) : OnDataChangeListener{
    ObxManager.instance.subscribe(this, listener)
    return listener
}

fun OnDataChangeListener.bind(lifecycleOwner: LifecycleOwner){
    lifecycleOwner.lifecycle.addObserver(ObxLifeCycleObserver(this))
}

fun OnDataChangeListener.bind(view: View){
    view.doOnDetach {
        ObxManager.instance.remove(this)
    }
}

fun OnDataChangeListener.init() : OnDataChangeListener{
    this.update()
    return this
}

fun OnDataChangeListener.remove(){
    ObxManager.instance.remove(this)
}

fun Any.clear(){
    ObxManager.instance.clear(this)
}