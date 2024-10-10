package com.example.webtooninfoapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "webtoon_ratings")
data class UserRatingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val webtoonTitle: String,
    val userId: String,
    var rating: Float = 0f
)

