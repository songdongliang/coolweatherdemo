package com.sdl.coolweather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sdl.coolweather.data.DATABASE_NAME
import com.sdl.coolweather.data.model.place.City
import com.sdl.coolweather.data.model.place.Country
import com.sdl.coolweather.data.model.place.Province

/**
 * create by songdongliang on 2019/8/6
 */
@Database(entities = [Province::class, Country::class, City::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun placeDao(): PlaceDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                }).build()
        }
    }
}