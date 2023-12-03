package com.softwareit.gallery_animation.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.softwareit.gallery_animation.data.DataSource
import com.softwareit.gallery_animation.data.LocalDataSource
import com.softwareit.gallery_animation.presentation.adapter.StellListAdapter
import com.softwareit.gallery_animation.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private val binding by lazy { FragmentGalleryBinding.inflate(layoutInflater) }
    private val dataSource: DataSource = LocalDataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val adapter = StellListAdapter(dataSource.getSteels()) { stell, extras ->
            findNavController().navigate(
                GalleryFragmentDirections.actionGalleryFragmentToStellFragment(
                    stell.id
                ), extras
            )
        }
        binding.stellRecyclerView.adapter = adapter

        postponeEnterTransition()
        binding.stellRecyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
        return binding.root
    }
}