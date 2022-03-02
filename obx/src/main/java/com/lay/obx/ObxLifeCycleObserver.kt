package com.lay.obx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ObxLifeCycleObserver(var listener: OnDataChangeListener) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        ObxManager.instance.remove(listener)
    }
}