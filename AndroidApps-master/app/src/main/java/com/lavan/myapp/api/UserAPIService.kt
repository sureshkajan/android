package com.lavan.myapp.api

import com.lavan.myapp.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPIService {
    @GET("users/{id}")
    fun getUser(@Path("id") id: String): Call<User>

    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): UserAPIService {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(UserAPIService::class.java)
        }


    }
    }