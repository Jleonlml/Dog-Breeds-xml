package com.devartdgo.testapp.network

import com.devartdgo.testapp.model.DogBreedImageResponse
import com.devartdgo.testapp.model.DogBreedsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogBreedsApi {
    @GET("breeds/list/all")
    suspend fun getAllBreeds(): DogBreedsResponse

    @GET("breed/{breed}/images")
    suspend fun getBreedImages(@Path("breed") breed: String): DogBreedImageResponse
}