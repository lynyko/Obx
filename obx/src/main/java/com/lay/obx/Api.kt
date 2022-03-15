package com.lay.obx

import android.content.Context
import androidx.lifecycle.LifecycleOwner

val <T : Any> T.obx : Obx<T>
    get() = Obx(this, key = this::class.java.name)

fun <T : Any> T.obx(key : String) : Obx<T>{
    return Obx(this, key = key)
}

inline fun <reified T : Any> obx() : Obx<T>{
    val obx = Obx<T>()
    obx.key = T::class.java.name
    return obx
}

inline fun <reified T : Any> Obx<T>.bind(lifecycleOwner: LifecycleOwner) : Obx<T>{
    if(this.key == ""){
        this.key = T::class.java.name
    }
    ObxManager.instance.addObxWithLifecycleOwner(lifecycleOwner.hashCode(), this)
    return this
}

fun <T : Any> Context.findObx(key : String) : Obx<T>?{
    return ObxManager.instance.findWithLifecycleOwner(hashCode(), key)
}

fun <T : Any> Context.findObx(clz : Class<T>) : Obx<T>?{
    val c = if(clz == Int::class.java) Integer::class.java else clz
    return findObx(c.name)
}


fun <T : Any> Obx<T>.update(init: Obx<T>.() -> Unit) {
    this.init()
    ObxManager.instance.update(this)
}

fun <T : Any> Obx<T>.subscribe(listener: OnDataChangeListener<T>): Obx<T> {
    ObxManager.instance.subscribe(this, listener)
    return this
}

fun <T : Any> Obx<T>.init(): Obx<T> {
    ObxManager.instance.update(this)
    return this
}