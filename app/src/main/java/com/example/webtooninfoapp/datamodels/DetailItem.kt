package com.example.webtooninfoapp.datamodels

sealed class DetailItem {
    data class MangaHeader(val imageUrl: String, val title: String, val rating: Float, val description: String) : DetailItem()
    data class SectionHeader(val title: String) : DetailItem()
    data class CharacterItem(val name: String, val imageUrl: String, val description: String) : DetailItem()
}
