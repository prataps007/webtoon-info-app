package com.example.webtooninfoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.webtooninfoapp.entities.FavoriteWebtoonEntity
import com.example.webtooninfoapp.repositories.WebtoonRepository
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: WebtoonRepository) : ViewModel() {

    val favorites: LiveData<List<FavoriteWebtoonEntity>> = liveData {
        emit(repository.getFavorites())
    }

    fun addFavorite(webtoon: FavoriteWebtoonEntity) {
        viewModelScope.launch {
            repository.addFavorite(webtoon)
        }
    }

//    fun deleteFavorite(favoriteWebtoon: FavoriteWebtoonEntity) {
//        viewModelScope.launch {
//            repository.deleteFavorite(favoriteWebtoon)
//        }
//    }

}
