package com.example.chaindaggerretrorecyclermvvm.di

import com.example.chaindaggerretrorecyclermvvm.utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetroModule {

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): RetroServiceInterface {
        return retrofit.create(RetroServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}