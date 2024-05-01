package com.devartdgo.testapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.devartdgo.testapp.R
import com.devartdgo.testapp.adapter.DogBreedsRVAdapter
import com.devartdgo.testapp.databinding.FragmentDogImageBinding
import com.devartdgo.testapp.databinding.FragmentListBinding
import com.devartdgo.testapp.viewmodel.DogBreedImageViewmodel
import com.devartdgo.testapp.viewmodel.DogBreedsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.full.memberProperties

@AndroidEntryPoint
class DogImageFragment : Fragment() {
    private val viewModel: DogBreedImageViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDogImageBinding.inflate(inflater, container, false)
        arguments?.getString("breed")?.let { viewModel.getBreedImages(it) }
        viewModel.dogBreedImagesLD.observe(viewLifecycleOwner) { images ->
            if (images != null) {
                Glide.with(this).load(images.message[0]).into(binding.ivDogBreedImg);
            }
        }
        return binding.root
    }
}