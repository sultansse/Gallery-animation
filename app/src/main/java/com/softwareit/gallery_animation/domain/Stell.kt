package com.softwareit.gallery_animation.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Stell(
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)
