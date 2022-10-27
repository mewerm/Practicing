package com.example.chaindaggerretrorecyclermvvm

import android.app.Application
import com.example.chaindaggerretrorecyclermvvm.di.DaggerRetroComponent
import com.example.chaindaggerretrorecyclermvvm.di.RetroComponent
import com.example.chaindaggerretrorecyclermvvm.di.RetroModule

class MyApplication : Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent{
        return retroComponent
    }

}