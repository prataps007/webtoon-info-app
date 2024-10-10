package com.example.webtooninfoapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.webtooninfoapp.Webtoon

@Entity(tableName = "webtoons")
data class WebtoonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val imageResId: Int
    //val imageUrl: String
)

// extension function to convert WebtoonEntity to Webtoon
fun WebtoonEntity.toWebtoon(): Webtoon {
    return Webtoon(
        title = this.title,
        description = this.description,
        imageResId = this.imageResId
    )
}
