package com.softwareit.gallery_animation.data

import com.softwareit.gallery_animation.domain.Stell

interface DataSource {
    fun getSteels(): List<Stell>
}