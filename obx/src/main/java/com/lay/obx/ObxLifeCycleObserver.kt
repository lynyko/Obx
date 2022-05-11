package com.lay.obx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent


class ObxLifeCycleObserver(var hashCode : Int) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner){
        owner.lifecycle.removeObserver(this)
        ObxManager.instance.removeObxWithLifecycleOwner(hashCode)
    }
}