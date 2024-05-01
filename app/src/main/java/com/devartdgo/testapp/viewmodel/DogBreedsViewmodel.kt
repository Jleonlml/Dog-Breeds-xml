package com.devartdgo.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devartdgo.testapp.model.DogBreedsResponse
import com.devartdgo.testapp.repository.DogBreedsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedsViewModel @Inject constructor(private val repository: DogBreedsRepository): ViewModel() {

    private val _DogBreedsLD = MutableLiveData<DogBreedsResponse?>()
    val dogBreedsLD : LiveData<DogBreedsResponse?> = _DogBreedsLD

    init {
        getAllBreeds()
    }

    private fun getAllBreeds() {
        viewModelScope.launch {
            try {
                _DogBreedsLD.value = repository.getAllBreeds()
            }
            catch (e: Exception) {
                //handle exception
            }
        }
    }
}