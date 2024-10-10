package com.example.webtooninfoapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_webtoons")
data class FavoriteWebtoonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String?,
    val description: String?,
    val imageResId: Int
)
