package com.example.chaindaggerretrorecyclermvvm.di

import com.example.chaindaggerretrorecyclermvvm.model.RecyclerList
import com.example.chaindaggerretrorecyclermvvm.utils.END_POINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET(END_POINT)
    fun getDataFromAPI(
        @Query("q") query: String
    ): Call<RecyclerList>
}