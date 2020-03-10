package com.example.moviedolphin

import android.app.Application
import com.example.moviedolphin.di.AppComponent
import com.example.moviedolphin.di.DaggerAppComponent

class BaseApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent(){
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }


}