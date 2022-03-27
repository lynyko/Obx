package com.lay.obx

import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Obx<GlobalModel>().bind(this)
    }
}