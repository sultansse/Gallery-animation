package com.softwareit.gallery_animation.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.softwareit.gallery_animation.domain.Stell
import com.softwareit.gallery_animation.databinding.ItemStellBinding

class StellListAdapter(
    private val stellList: List<Stell>,
    private val onStellClick: (Stell, FragmentNavigator.Extras) -> Unit,
) : RecyclerView.Adapter<StellListAdapter.SteelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SteelViewHolder {
        return SteelViewHolder(
            ItemStellBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SteelViewHolder, position: Int) {
        holder.bind(stellList[position])
    }

    override fun getItemCount(): Int = stellList.size

    inner class SteelViewHolder(
        private val binding: ItemStellBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(stell: Stell) {
            with(binding) {
                title.text = itemView.context.getString(stell.name)
                image.setImageResource(stell.image)

                title.transitionName = "title" + stell.id.toString()
                image.transitionName = "image" + stell.id.toString()

                val extras = FragmentNavigatorExtras(
                    title to "title",
                    image to "image",
                )

                root.setOnClickListener {
                    onStellClick(stell, extras)
                }
            }
        }
    }
}