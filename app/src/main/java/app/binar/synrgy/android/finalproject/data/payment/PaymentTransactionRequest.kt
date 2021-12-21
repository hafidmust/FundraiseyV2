package app.binar.synrgy.android.finalproject.data.payment

import com.google.gson.annotations.SerializedName

data class PaymentTransactionRequest(

    @field:SerializedName("loanId")
    val loanId: Int? = null,

    @field:SerializedName("amount")
    val amount: Int? = null,

    @field:SerializedName("paymentAgentId")
    val paymentAgentId: Int? = null

)