package app.binar.synrgy.android.finalproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryCache(
    @PrimaryKey val id: String,
    val nameLoan : String,
    val nameStartup : String,
    val amountFund : Int,
    val paymentDeadline : String,
    val campaignDeadline : String,
    val statusPayment : String
    )