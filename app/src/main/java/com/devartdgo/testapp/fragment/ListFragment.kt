package com.devartdgo.testapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devartdgo.testapp.R
import com.devartdgo.testapp.adapter.DogBreedsRVAdapter
import com.devartdgo.testapp.databinding.FragmentListBinding
import com.devartdgo.testapp.viewmodel.DogBreedsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.full.memberProperties


@AndroidEntryPoint
class ListFragment : Fragment() {
    private val viewModel: DogBreedsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater,container, false)
        viewModel.dogBreedsLD.observe(viewLifecycleOwner) { breeds ->
            if (breeds != null) {
                val breedList = breeds.message::class.memberProperties.map {
                    it.name
                }.toList()

                binding.rvDogBreedsList.apply {
                    layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    adapter = DogBreedsRVAdapter(object : DogBreedsRVAdapter.OnItemClickListener {
                        override fun onItemClick(item: String?) {
                            val navHostFragment =
                                requireActivity().supportFragmentManager.primaryNavigationFragment as NavHostFragment
                            val navController = navHostFragment.navController
                            val bundle = bundleOf("breed" to item)
                            navController.navigate(R.id.action_home_to_image, bundle)
                        }
                    }).apply {
                        updateItems(
                            breedList
                        )
                    }
                }
            }
        }

        return binding.root
    }
}