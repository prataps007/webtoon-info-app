package com.example.webtooninfoapp.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webtooninfoapp.R
import com.example.webtooninfoapp.adapters.CharacterAdapter
import com.example.webtooninfoapp.database.WebtoonDatabase
import com.example.webtooninfoapp.entities.DetailedWebtoonInfo
import com.example.webtooninfoapp.entities.FavoriteWebtoonEntity
import com.example.webtooninfoapp.entities.UserRatingEntity
import com.example.webtooninfoapp.utils.WebtoonData
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var webtoonImage: ImageView
    private lateinit var webtoonTitle: TextView
    private lateinit var webtoonDescription: TextView

    private lateinit var averageRatingText: TextView

    private lateinit var detailedDescriptionTextView: TextView
    private lateinit var characterRecyclerView: RecyclerView

    private var webtoonTitleStr: String? = null
    private var userHasRated: Boolean = false
    private var totalRatings: Int = 0
    private var totalScore: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        webtoonImage = findViewById(R.id.detailImage)
        webtoonTitle = findViewById(R.id.detailTitle)
        webtoonDescription = findViewById(R.id.detailDescription)
        //addToFavoritesButton = findViewById(R.id.addToFavoritesButton)

        detailedDescriptionTextView = findViewById(R.id.detailedDescription)

        characterRecyclerView = findViewById(R.id.characterRecyclerView)
        // Set up LinearLayoutManager with horizontal orientation
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        characterRecyclerView.layoutManager = layoutManager
        //characterRecyclerView.layoutManager = LinearLayoutManager(this)

        averageRatingText = findViewById(R.id.averageRatingText)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        // back button
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            onBackPressed()
        }

        val title = intent.getStringExtra("WEBTOON_TITLE")
        webtoonTitleStr = title
        val description = intent.getStringExtra("WEBTOON_DESCRIPTION")
        val image = intent.getIntExtra("WEBTOON_IMAGE", 0)

        // Set the title of the toolbar to the manga name
        var toolbarTitle = findViewById<TextView>(R.id.mangaTitle)
        toolbarTitle.text = title

        // Set data to views
        webtoonTitle.text = title
        webtoonDescription.text = description
        webtoonImage.setImageResource(image)

        // Load webtoon ratings from the database
        loadWebtoonRatings()


        // Load more detailed info from the database or WebtoonData
        loadWebtoonDetails()
    }

    private fun loadWebtoonDetails() {

        lifecycleScope.launch {
                WebtoonData.detailedInfoAboutWebtoons[webtoonTitleStr]?.let {
                    populateDetailedInfo(it)
                }
            //}
        }
    }

    private fun populateDetailedInfo(detailedInfo: DetailedWebtoonInfo) {
        // Set the detailed description
        detailedDescriptionTextView.text = detailedInfo.detailedDescription

        // Set up the RecyclerView with characters
        val allCharacters = detailedInfo.majorCharacters + detailedInfo.minorCharacters
        val adapter = CharacterAdapter(allCharacters)
        characterRecyclerView.adapter = adapter
    }

    private fun loadWebtoonRatings() {
        val database = WebtoonDatabase.getDatabase(this)
        lifecycleScope.launch {
            // Check if the user has rated this webtoon
            val userRating = database.userRatingDao().getRatingForWebtoon(webtoonTitleStr)
            if (userRating != null) {
                userHasRated = true // User  rated this webtoon
            }

            // Load the average rating of the webtoon from the rating database
            val ratingsList = database.userRatingDao().getAllRatingsForWebtoon(webtoonTitleStr)
            if (ratingsList.isNotEmpty()) {
                totalRatings = ratingsList.size
                totalScore = ratingsList.sumOf { it.rating.toDouble() }.toFloat()

                val averageRating = totalScore / totalRatings
                averageRatingText.text = "Average Rating: ${String.format("%.1f", averageRating)}"
            }
        }
    }

    // on back press show the rating dialog if the user hasn't rated yet
    override fun onBackPressed() {
        if (!userHasRated) {
            showRatingDialog()
        } else {
            super.onBackPressed()
        }
    }

    private fun showRatingDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_provide_rating, null)
        val ratingBar = dialogView.findViewById<RatingBar>(R.id.ratingBar)
        val submitButton = dialogView.findViewById<Button>(R.id.submitRatingButton)
        val remindMeLaterButton = dialogView.findViewById<Button>(R.id.remindMeLaterButton)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        submitButton.setOnClickListener {
            val userRating = ratingBar.rating
            if (userRating > 0) {
                submitRating(userRating)
                dialog.dismiss()
                super.onBackPressed()
            } else {
                Toast.makeText(this, "Please provide a rating before proceeding.", Toast.LENGTH_SHORT).show()
            }
        }

        remindMeLaterButton.setOnClickListener {
            dialog.dismiss()
            super.onBackPressed()
        }

        dialog.show()
    }

    private fun submitRating(userRating: Float) {
        // new average rating
        totalRatings++
        totalScore += userRating
        val newAverageRating = totalScore / totalRatings

        // Save user's rating to the database
        val database = WebtoonDatabase.getDatabase(this)
        lifecycleScope.launch {
            val userRatingEntity = UserRatingEntity(
                webtoonTitle = webtoonTitleStr ?: "",
                userId = "CURRENT_USER_ID",
                rating = userRating
            )
            database.userRatingDao().insert(userRatingEntity)

            // Update UI and average rating
            updateRatingUI(newAverageRating)
            Toast.makeText(this@DetailActivity, "Rating submitted!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateRatingUI(newAverageRating: Float) {
        averageRatingText.text = "Average Rating: ${String.format("%.1f", newAverageRating)}"
    }

    private fun saveFavoriteWebtoon(webtoon: FavoriteWebtoonEntity) {
        val database = WebtoonDatabase.getDatabase(this)
        lifecycleScope.launch {
            database.favoriteWebtoonDao().insert(webtoon)
            Toast.makeText(this@DetailActivity, "${webtoon.title} added to favorites!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_watch_later -> {
                Toast.makeText(this, "Added to Watch Later", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_add_to_favorites -> {
                val favoriteWebtoon = FavoriteWebtoonEntity(
                    title = webtoonTitleStr,
                    description = webtoonDescription.text.toString(),
                    imageResId = intent.getIntExtra("WEBTOON_IMAGE", 0)
                )
                saveFavoriteWebtoon(favoriteWebtoon)
                true
            }
            R.id.action_rate_this_webtoon -> {
                showRatingDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
