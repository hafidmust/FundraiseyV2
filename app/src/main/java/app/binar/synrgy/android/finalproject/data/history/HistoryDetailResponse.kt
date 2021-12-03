package app.binar.synrgy.android.finalproject.data.history

import com.google.gson.annotations.SerializedName

data class HistoryDetailResponse(

	@field:SerializedName("data")
	val data: DataDetail,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class PaymentAgentDetail(

	@field:SerializedName("transactionMethod")
	val transactionMethod: TransactionMethodDetail,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class InvestorDetail(

	@field:SerializedName("profilePicture")
	val profilePicture: String,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("fullName")
	val fullName: String,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("citizenID")
	val citizenID: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any
)

data class LoanDetail(

	@field:SerializedName("interestRate")
	val interestRate: Double,

	@field:SerializedName("paymentPlan")
	val paymentPlan: PaymentPlanDetail,

	@field:SerializedName("endDate")
	val endDate: String,

	@field:SerializedName("withdrawn")
	val withdrawn: Boolean,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("totalReturnPeriod")
	val totalReturnPeriod: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("loanComment")
	val loanComment: List<Any>,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("targetValue")
	val targetValue: Int,

	@field:SerializedName("withdrawalInvoice")
	val withdrawalInvoice: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("startDate")
	val startDate: String,

	@field:SerializedName("status")
	val status: String
)

data class DataDetail(

	@field:SerializedName("loan")
	val loan: LoanDetail,

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("transactionStatus")
	val transactionStatus: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("paymentVerificationUrl")
	val paymentVerificationUrl: Any,

	@field:SerializedName("paymentAgent")
	val paymentAgent: PaymentAgentDetail,

	@field:SerializedName("accountNumber")
	val accountNumber: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("returnInstallments")
	val returnInstallments: List<Any>,

	@field:SerializedName("investor")
	val investor: InvestorDetail,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("paymentDeadline")
	val paymentDeadline: String,

	@field:SerializedName("id")
	val id: Int
)

data class PaymentPlanDetail(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class TransactionMethodDetail(

	@field:SerializedName("name")
	val name: String
)
