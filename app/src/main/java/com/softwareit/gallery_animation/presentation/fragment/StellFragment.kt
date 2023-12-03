package com.softwareit.gallery_animation.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.softwareit.gallery_animation.data.DataSource
import com.softwareit.gallery_animation.data.LocalDataSource
import com.softwareit.gallery_animation.databinding.FragmentStellBinding
import java.util.concurrent.TimeUnit

class StellFragment : Fragment() {

    private val binding by lazy { FragmentStellBinding.inflate(layoutInflater) }
    private val dataSource: DataSource = LocalDataSource
    private val args: StellFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val stellList = dataSource.getSteels()
        val stell = stellList.find { it.id == args.id } ?: error("unknown id")

        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        postponeEnterTransition(200, TimeUnit.MILLISECONDS)

        binding.title.text = getString(stell.name)
        binding.imageView.setImageResource(stell.image)
        binding.imageView.setOnClickListener {
            binding.imageView.animate()
                .rotationXBy(360f)
                .setDuration(1000)
                .start()
        }
        return binding.root
    }
}