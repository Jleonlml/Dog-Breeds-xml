package com.devartdgo.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devartdgo.testapp.model.DogBreedImageResponse
import com.devartdgo.testapp.repository.DogBreedsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedImageViewmodel @Inject constructor(private val repository: DogBreedsRepository): ViewModel(){

    private val _dogBreedImagesLD = MutableLiveData<DogBreedImageResponse>()
    val dogBreedImagesLD : LiveData<DogBreedImageResponse?> = _dogBreedImagesLD

    fun getBreedImages(breed: String) {
        viewModelScope.launch {
            try {
                _dogBreedImagesLD.value = repository.getBreedImages(breed)
            }
            catch (e: Exception) {
                //handle exception
            }
        }
    }
}