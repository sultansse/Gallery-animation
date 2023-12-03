package com.softwareit.gallery_animation.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.softwareit.gallery_animation.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.titleStell.animate()
            .translationY(200f)
            .setDuration(800)
            .start()

        binding.titleGallery.animate()
            .translationY(200f)
            .setDuration(800)
            .start()

        binding.description.translationX = -1000f
        binding.description.animate()
            .translationX(0f)
            .setStartDelay(400L)
            .setDuration(1000)
            .start()

        binding.letsGoButton.animate()
            .translationY(-200f)
            .setDuration(500)
            .setStartDelay(1200L)
            .start()

        binding.letsGoButton.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToGalleryFragment()
            )
        }
        return binding.root
    }
}