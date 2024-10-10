package com.example.webtooninfoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.webtooninfoapp.dao.FavoriteWebtoonDao
import com.example.webtooninfoapp.dao.UserRatingDao
import com.example.webtooninfoapp.entities.FavoriteWebtoonEntity
import com.example.webtooninfoapp.entities.UserRatingEntity

@Database(entities = [FavoriteWebtoonEntity::class, UserRatingEntity::class], version = 3, exportSchema = false)
abstract class WebtoonDatabase : RoomDatabase() {

    abstract fun favoriteWebtoonDao(): FavoriteWebtoonDao
    abstract fun userRatingDao(): UserRatingDao

    companion object {
        @Volatile
        private var INSTANCE: WebtoonDatabase? = null

        fun getDatabase(context: Context): WebtoonDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WebtoonDatabase::class.java,
                    "webtoon_database"
                )
                    //.fallbackToDestructiveMigration() // for destructive migration
                    .build()

                INSTANCE = instance
                instance
            }
        }

    }
}
