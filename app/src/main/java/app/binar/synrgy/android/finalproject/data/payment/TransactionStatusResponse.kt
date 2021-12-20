package app.binar.synrgy.android.finalproject.data.payment

import com.google.gson.annotations.SerializedName

data class TransactionStatusResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int
)
