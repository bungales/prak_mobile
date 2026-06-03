package com.example.bungaapps.Data.Api

import com.example.bungaapps.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}