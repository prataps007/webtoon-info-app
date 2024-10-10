package com.example.webtooninfoapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webtooninfoapp.entities.FavoriteWebtoonEntity

@Dao
interface FavoriteWebtoonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteWebtoon: FavoriteWebtoonEntity)

    @Query("SELECT * FROM favorite_webtoons")
    suspend fun getAllFavorites(): List<FavoriteWebtoonEntity>

    @Delete
    suspend fun delete(favoriteWebtoon: FavoriteWebtoonEntity)
}
