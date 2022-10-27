package com.example.chaindaggerretrorecyclermvvm.di

import com.example.chaindaggerretrorecyclermvvm.ui.viewmodel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
open interface RetroComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}