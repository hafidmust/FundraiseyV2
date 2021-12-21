package app.binar.synrgy.android.finalproject.data.payment

import com.google.gson.annotations.SerializedName

data class TransactionStatusRequest(

    @field:SerializedName("transactionId")
    val transactionId: Int? = null

)
