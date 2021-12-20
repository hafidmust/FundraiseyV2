package app.binar.synrgy.android.finalproject.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, exportSchema = false, entities = [HistoryCache::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao() : HomeDao

    companion object{
        private var instance : AppDatabase  ?= null
        @Synchronized
        fun getInstance(context : Context) : AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Fundraisey"
                ).build()
            }
            return instance!!
        }
    }
}