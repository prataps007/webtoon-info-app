package com.example.webtooninfoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.webtooninfoapp.repositories.WebtoonRepository
import com.example.webtooninfoapp.viewmodel.FavoritesViewModel

class FavoritesViewModelFactory(
    private val repository: WebtoonRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



