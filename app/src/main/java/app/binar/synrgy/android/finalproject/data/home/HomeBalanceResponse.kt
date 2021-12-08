package app.binar.synrgy.android.finalproject.data.home

import com.google.gson.annotations.SerializedName

data class HomeBalanceResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class Data(

	@field:SerializedName("totalWithdrawn")
	val totalWithdrawn: Int,

	@field:SerializedName("totalReturn")
	val totalReturn: Int,

	@field:SerializedName("upcomingReturn")
	val upcomingReturn: Int,

	@field:SerializedName("loanTransactionCount")
	val loanTransactionCount: Int,

	@field:SerializedName("totalWithdrawnThisMonth")
	val totalWithdrawnThisMonth: Int,

	@field:SerializedName("totalFunding")
	val totalFunding: Int,

	@field:SerializedName("balance")
	val balance: Int,

)
