package app.binar.synrgy.android.finalproject.data.portofolio

import com.google.gson.annotations.SerializedName

data class PortofolioSummaryResponse(

    @field:SerializedName("data")
    val data: summary? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null

)

data class summary(

    @field:SerializedName("totalWithdrawn")
    val totalWithdrawn: Int? = null,

    @field:SerializedName("totalWithdrawnThisMonth")
    val totalWithdrawnThisMonth: Int? = null,

    @field:SerializedName("totalFunding")
    val totalFunding: Int? = null,

    @field:SerializedName("totalReturn")
    val totalReturn: Int? = null,

    @field:SerializedName("upcomingReturn")
    val upcomingReturn: Int? = null,

    @field:SerializedName("loanTransactionCount")
    val loanTransactionCount: Int? = null,

)