package com.example.webtooninfoapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webtooninfoapp.entities.UserRatingEntity

@Dao
interface UserRatingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userRating: UserRatingEntity)

    @Query("SELECT * FROM webtoon_ratings WHERE webtoonTitle = :webtoonTitle AND userId = :userId LIMIT 1")
    suspend fun getRatingForWebtoon(webtoonTitle: String?, userId: String = "CURRENT_USER_ID"): UserRatingEntity?

    @Query("SELECT * FROM webtoon_ratings WHERE webtoonTitle = :webtoonTitle")
    suspend fun getAllRatingsForWebtoon(webtoonTitle: String?): List<UserRatingEntity>
}
