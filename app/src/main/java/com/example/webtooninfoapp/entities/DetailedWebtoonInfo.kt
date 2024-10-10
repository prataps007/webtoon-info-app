package com.example.webtooninfoapp.entities

import java.lang.Character


data class DetailedWebtoonInfo(
    val detailedDescription: String,
    val majorCharacters: List<Characters>,
    val minorCharacters: List<Characters>
)

data class Characters(
    val name: String,
    val imageResId: Int?, // Resource ID for character image
    val about: String
)
