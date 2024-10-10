package com.example.webtooninfoapp.repositories

import com.example.webtooninfoapp.dao.FavoriteWebtoonDao
import com.example.webtooninfoapp.entities.FavoriteWebtoonEntity
import com.example.webtooninfoapp.entities.WebtoonEntity

class WebtoonRepository(private val favoriteWebtoonDao: FavoriteWebtoonDao) {

    suspend fun addFavorite(webtoon: FavoriteWebtoonEntity) {
        favoriteWebtoonDao.insert(webtoon)
    }

    suspend fun getFavorites(): List<FavoriteWebtoonEntity> {
        return favoriteWebtoonDao.getAllFavorites()
    }
}
