package app.binar.synrgy.android.finalproject.data.history

import com.google.gson.annotations.SerializedName

data class DetailHistoryResponse(

	@field:SerializedName("data")
	val data: DataDetail,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class StartupDetail(

	@field:SerializedName("youtube")
	val youtube: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("credentials")
	val credentials: List<CredentialsItemDetail>,

	@field:SerializedName("foundedDate")
	val foundedDate: Any,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("linkedin")
	val linkedin: String,

	@field:SerializedName("instagram")
	val instagram: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("products")
	val products: List<ProductsItemDetail>,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("web")
	val web: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("logo")
	val logo: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("email")
	val email: String
)

data class LoanDetail(

	@field:SerializedName("interestRate")
	val interestRate: Int,

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

	@field:SerializedName("startup")
	val startup: StartupDetail,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("targetValue")
	val targetValue: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("startDate")
	val startDate: String,

	@field:SerializedName("status")
	val status: String
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
	val id: Int,

	@field:SerializedName("interestRate")
	val interestRate: Double? = null,



)

data class PaymentPlanHistory(
	@SerializedName("id") var id : Int?    = null,
	@SerializedName("name") var name : String? = null,
	@SerializedName("interestRate") var interestRate : Int? = null,
	@SerializedName("monthInterval") var monthInterval: Int? = null,
	@SerializedName("totalPeriod") var totalPeriod : Int?= null
)

data class CredentialsItemDetail(

	@field:SerializedName("credentialUrl")
	val credentialUrl: String,

	@field:SerializedName("documents")
	val documents: List<DocumentsItemDetail>,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("credentialType")
	val credentialType: CredentialTypeDetail,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("credentialId")
	val credentialId: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("issueDate")
	val issueDate: String,

	@field:SerializedName("issuingOrganization")
	val issuingOrganization: String,

	@field:SerializedName("expirationDate")
	val expirationDate: String,

	@field:SerializedName("status")
	val status: String
)

data class DocumentsItemDetail(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("url")
	val url: String
)

data class PaymentPlanDetail(

	@SerializedName("id") var id: Int? = null,
	@SerializedName("name") var name: String? = null,
	@SerializedName("interestRate") var interestRate: Int? = null,
	@SerializedName("monthInterval") var monthInterval: Int? = null,
	@SerializedName("totalPeriod") var totalPeriod: Int? = null


)

data class TransactionMethodDetail(

	@field:SerializedName("name")
	val name: String
)

data class CredentialTypeDetail(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any
)

data class ProductsItemDetail(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("productPhotos")
	val productPhotos: List<ProductPhotosItemDetail>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("url")
	val url: String
)

data class PaymentAgentDetail(

	@field:SerializedName("transactionMethod")
	val transactionMethod: TransactionMethodDetail,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class ProductPhotosItemDetail(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("url")
	val url: String
)
