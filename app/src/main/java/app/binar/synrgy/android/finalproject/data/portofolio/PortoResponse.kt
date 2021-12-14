package app.binar.synrgy.android.finalproject.data.portofolio

import com.google.gson.annotations.SerializedName

data class PortoResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class Payment(

	@field:SerializedName("returnDate")
	val returnDate: String,

	@field:SerializedName("returnPeriod")
	val returnPeriod: Int,

	@field:SerializedName("status")
	val status: String
)

data class PaymentInvoice(

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("paymentDate")
	val paymentDate: String
)

data class DataItem(

	@field:SerializedName("loanName")
	val loanName: String,

	@field:SerializedName("endDate")
	val endDate: String,

	@field:SerializedName("currentLoanValue")
	val currentLoanValue: Int,

	@field:SerializedName("paymentPlanName")
	val paymentPlanName: String,

	@field:SerializedName("startupName")
	val startupName: String,

	@field:SerializedName("targetLoanValue")
	val targetLoanValue: Int,

	@field:SerializedName("returnInstallment")
	val returnInstallment: List<ReturnInstallmentItem>,

	@field:SerializedName("startupId")
	val startupId: Int,

	@field:SerializedName("paymentPlanId")
	val paymentPlanId: Int,

	@field:SerializedName("transactionId")
	val transactionId: Int,

	@field:SerializedName("loanId")
	val loanId: Int,

	@field:SerializedName("startDate")
	val startDate: String
)

data class ReturnInstallmentItem(

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("returnInvoice")
	val returnInvoice: Any,

	@field:SerializedName("withdrawn")
	val withdrawn: Boolean,

	@field:SerializedName("returnStatus")
	val returnStatus: String,

	@field:SerializedName("paymentInvoice")
	val paymentInvoice: Any,

	@field:SerializedName("payment")
	val payment: Payment,

	@field:SerializedName("id")
	val id: Int
)
