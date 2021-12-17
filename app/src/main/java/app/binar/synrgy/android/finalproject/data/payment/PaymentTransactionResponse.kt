package app.binar.synrgy.android.finalproject.data.payment

import com.google.gson.annotations.SerializedName

data class PaymentTransactionResponse(

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int

)
