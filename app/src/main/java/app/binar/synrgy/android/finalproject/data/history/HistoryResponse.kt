package app.binar.synrgy.android.finalproject.data.history

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class ProductsItem(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("productPhotos")
	val productPhotos: List<ProductPhotosItem>,

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

data class ContentItem(

	@field:SerializedName("loan")
	val loan: Loan,

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("transactionStatus")
	val transactionStatus: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("paymentVerificationUrl")
	val paymentVerificationUrl: Any,

	@field:SerializedName("paymentAgent")
	val paymentAgent: PaymentAgent,

	@field:SerializedName("accountNumber")
	val accountNumber: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("returnInstallments")
	val returnInstallments: List<Any>,

	@field:SerializedName("investor")
	val investor: Investor,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("paymentDeadline")
	val paymentDeadline: String,

	@field:SerializedName("id")
	val id: Int
)

data class Data(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("last")
	val last: Boolean,

	@field:SerializedName("numberOfElements")
	val numberOfElements: Int,

	@field:SerializedName("size")
	val size: Int,

	@field:SerializedName("totalPages")
	val totalPages: Int,

	@field:SerializedName("pageable")
	val pageable: Pageable,

	@field:SerializedName("sort")
	val sort: Sort,

	@field:SerializedName("content")
	val content: List<ContentItem>,

	@field:SerializedName("first")
	val first: Boolean,

	@field:SerializedName("totalElements")
	val totalElements: Int,

	@field:SerializedName("empty")
	val empty: Boolean
)

data class TransactionMethod(

	@field:SerializedName("name")
	val name: String
)

data class CredentialType(

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

data class ReturnInstallmentsItem(

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

data class PaymentAgent(

	@field:SerializedName("transactionMethod")
	val transactionMethod: TransactionMethod,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class Payment(

	@field:SerializedName("returnDate")
	val returnDate: String,

	@field:SerializedName("returnPeriod")
	val returnPeriod: Int,

	@field:SerializedName("status")
	val status: String
)

data class historyStartup(

	@field:SerializedName("youtube")
	val youtube: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("credentials")
	val credentials: List<CredentialsItem>,

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
	val products: List<ProductsItem>,

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

data class CredentialsItem(

	@field:SerializedName("credentialUrl")
	val credentialUrl: String,

	@field:SerializedName("documents")
	val documents: List<DocumentsItem>,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("credentialType")
	val credentialType: CredentialType,

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

data class ProductPhotosItem(

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

data class PaymentInvoice(

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("paymentDate")
	val paymentDate: String
)

data class Loan(

	@field:SerializedName("interestRate")
	val interestRate: Double,

	@field:SerializedName("paymentPlan")
	val paymentPlan: PaymentPlan,

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
	val startup: historyStartup,

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

data class DocumentsItem(

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

data class Pageable(

	@field:SerializedName("paged")
	val paged: Boolean,

	@field:SerializedName("pageNumber")
	val pageNumber: Int,

	@field:SerializedName("offset")
	val offset: Int,

	@field:SerializedName("pageSize")
	val pageSize: Int,

	@field:SerializedName("unpaged")
	val unpaged: Boolean,

	@field:SerializedName("sort")
	val sort: Sort
)

data class PaymentPlan(

	@field:SerializedName("interestRate")
	val interestRate: Double,

	@field:SerializedName("totalPeriod")
	val totalPeriod: Int,

	@field:SerializedName("monthInterval")
	val monthInterval: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class Investor(

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

	@field:SerializedName("bankAccountNumber")
	val bankAccountNumber: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("citizenID")
	val citizenID: String,

	@field:SerializedName("deleted_at")
	val deletedAt: Any
)

data class Sort(

	@field:SerializedName("unsorted")
	val unsorted: Boolean,

	@field:SerializedName("sorted")
	val sorted: Boolean,

	@field:SerializedName("empty")
	val empty: Boolean
)
