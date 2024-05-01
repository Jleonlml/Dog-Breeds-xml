package com.devartdgo.testapp.repository

import com.devartdgo.testapp.model.DogBreedImageResponse
import com.devartdgo.testapp.model.DogBreedsResponse
import com.devartdgo.testapp.network.DogBreedsApi
import javax.inject.Inject

class DogBreedsRepository @Inject constructor(private val api: DogBreedsApi) {
    suspend fun getAllBreeds(): DogBreedsResponse {
        return api.getAllBreeds()
    }

    suspend fun getBreedImages(breed: String): DogBreedImageResponse {
        return api.getBreedImages(breed)
    }
}