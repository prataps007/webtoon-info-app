package com.example.webtooninfoapp.activities

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webtooninfoapp.FavoritesViewModelFactory
import com.example.webtooninfoapp.R
import com.example.webtooninfoapp.adapters.FavoritesAdapter
import com.example.webtooninfoapp.database.WebtoonDatabase
import com.example.webtooninfoapp.repositories.WebtoonRepository
import com.example.webtooninfoapp.viewmodel.FavoritesViewModel

class FavoritesActivity : AppCompatActivity() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)


        val toolbar: Toolbar = findViewById(R.id.favoritesToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)


        // Back button
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

        // initialize ViewModel
        val dao = WebtoonDatabase.getDatabase(this).favoriteWebtoonDao()
        val repository = WebtoonRepository(dao)
        val viewModelFactory = FavoritesViewModelFactory(repository)
        favoritesViewModel = ViewModelProvider(this, viewModelFactory).get(FavoritesViewModel::class.java)

        favoritesAdapter = FavoritesAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = favoritesAdapter

        // observe favourites data
        favoritesViewModel.favorites.observe(this) { favorites ->
            favoritesAdapter.submitList(favorites)
        }
    }

}

