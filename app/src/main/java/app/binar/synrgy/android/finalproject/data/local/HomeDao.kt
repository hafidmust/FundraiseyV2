package app.binar.synrgy.android.finalproject.data.local

import androidx.room.*

@Dao
interface HomeDao {
    @Query("SELECT * FROM history")
    suspend fun getAllHistory() : List<HistoryCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHistory(vararg historyCache: HistoryCache)

    @Delete
    suspend fun deleteHistory(historyCache: HistoryCache)

    @Update
    suspend fun updateHistory(historyCache: HistoryCache)
}
