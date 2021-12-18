package app.binar.synrgy.android.finalproject.data.portofolio

import app.binar.synrgy.android.finalproject.data.payment.DataDetail
import com.google.gson.annotations.SerializedName

data class WithdrawLoanResponse(

    @field:SerializedName("data")
    val data: dataWithdrawn,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int

)

data class dataWithdrawn(

    @field:SerializedName("total withdrawn")
    val totalWithdrawn: Int,

    @field:SerializedName("withdraw success count")
    val withdrawSuccessCount: Int,

    @field:SerializedName("withdraw fail count")
    val withdrawFailCount: Int

)
