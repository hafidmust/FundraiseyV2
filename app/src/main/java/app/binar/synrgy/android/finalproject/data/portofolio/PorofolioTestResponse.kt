package app.binar.synrgy.android.finalproject.data.portofolio

import com.google.gson.annotations.SerializedName

data class PorofolioTestResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class ReturnInstallment(

	@field:SerializedName("returnDate")
	val returnDate: String? = null,

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("returnInvoice")
	val returnInvoice: ReturnInvoice? = null,

	@field:SerializedName("withdrawn")
	val withdrawn: Boolean? = null,

	@field:SerializedName("returnStatus")
	val returnStatus: String? = null,

	@field:SerializedName("totalReturnPeriod")
	val totalReturnPeriod: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("returnPeriod")
	val returnPeriod: Int? = null
)

data class ReturnInvoice(

	@field:SerializedName("bankAccount")
	val bankAccount: Any? = null,

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("paymentDate")
	val paymentDate: String? = null
)

data class Startup(

	@field:SerializedName("address")
	val address: Any? = null,

	@field:SerializedName("credentials")
	val credentials: List<Any?>? = null,

	@field:SerializedName("foundedDate")
	val foundedDate: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: Any? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("products")
	val products: List<Any?>? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("web")
	val web: Any? = null,

	@field:SerializedName("name")
	val name: Any? = null,

	@field:SerializedName("logo")
	val logo: Any? = null,

	@field:SerializedName("socialMedias")
	val socialMedias: List<Any?>? = null,

	@field:SerializedName("startupNotifications")
	val startupNotifications: List<Any?>? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class DataItem(

	@field:SerializedName("loan")
	val loan: Loan? = null,

	@field:SerializedName("returnInstallment")
	val returnInstallment: ReturnInstallment? = null
)

data class WithdrawalInvoice(

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("paymentDate")
	val paymentDate: String? = null
)

data class Loan(

	@field:SerializedName("interestRate")
	val interestRate: Double? = null,

	@field:SerializedName("paymentPlan")
	val paymentPlan: PaymentPlan? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("withdrawn")
	val withdrawn: Boolean? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("totalReturnPeriod")
	val totalReturnPeriod: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("startup")
	val startup: Startup? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("targetValue")
	val targetValue: Int? = null,

	@field:SerializedName("withdrawalInvoice")
	val withdrawalInvoice: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class PaymentPlan(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
