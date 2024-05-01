package com.devartdgo.testapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.devartdgo.testapp.R
import com.devartdgo.testapp.databinding.DogBreedItemBinding

class DogBreedsRVAdapter(private var listener: OnItemClickListener?) :
    GenericRecyclerViewAdapter<String>() {

    interface OnItemClickListener {
        fun onItemClick(item: String?)
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getBinder(parent: ViewGroup, viewType: Int, view: View): Binder<String> {
        return getBinder(view, parent.context)
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.dog_breed_item
    }

    private fun getBinder(view: View, context: Context): Binder<String> {
        return object : Binder<String>(view) {
            private val mBinding = DogBreedItemBinding.bind(view)
            override fun bind(item: String, position: Int) {
                mBinding.apply {
                    tvDogBreed.text = item
                    cvDogBreedCard.setOnClickListener {
                        listener?.onItemClick(item);
                    }
                }
            }
        }
    }
}