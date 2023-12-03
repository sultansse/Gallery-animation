package com.softwareit.gallery_animation.data

import com.softwareit.gallery_animation.R
import com.softwareit.gallery_animation.domain.Stell

object LocalDataSource : DataSource {
    override fun getSteels(): List<Stell> = listOf(
        Stell(
            id = 1,
            name = R.string.street,
            image = R.drawable.ic_street
        ),
        Stell(
            id = 2,
            name = R.string.advert,
            image = R.drawable.ic_advert
        ),
        Stell(
            id = 3,
            name = R.string.statue_of_freedom,
            image = R.drawable.ic_statue_of_freedom_1
        ),
        Stell(
            id = 4,
            name = R.string.statue_of_freedom,
            image = R.drawable.ic_statue_of_freedom_2
        ),
        Stell(
            id = 5,
            name = R.string.dog,
            image = R.drawable.ic_dog
        ),
        Stell(
            id = 6,
            name = R.string.bridge,
            image = R.drawable.ic_bridge
        ),
    )
}