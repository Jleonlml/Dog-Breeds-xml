package com.devartdgo.testapp.di

import com.devartdgo.testapp.network.DogBreedsApi
import com.devartdgo.testapp.repository.DogBreedsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Singleton
    @Provides
    fun providesRepository(api: DogBreedsApi) = DogBreedsRepository(api)

    @Singleton
    @Provides
    fun providesDogsApi(): DogBreedsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogBreedsApi::class.java)
    }

    companion object {
        const val BASE_URL = "https://dog.ceo/api/"
    }
}