package app.binar.synrgy.android.finalproject.data.history

import com.google.gson.annotations.SerializedName
import java.util.*

data class PaymentTransactionResponseSuccess(

    @field:SerializedName("data")
    val data: DataSuccess,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int
)

data class DataSuccess(

    @field:SerializedName("id")
    val idData: Int,

    @field:SerializedName("created_at")
    val created_at: Date,

    @field:SerializedName("updated_at")
    val updated_at: Date,

    @field:SerializedName("deleted_at")
    val deleted_at: Date,

    @field:SerializedName("amount")
    val amount: Int,

    @field:SerializedName("accountNumber")
    val accountNumber: Long,

    @field:SerializedName("paymentVerificationUrl")
    val paymentVerificationUrl: String,

    @field:SerializedName("paymentDeadline")
    val paymentDeadline: String,

    @field:SerializedName("returnInstallments")
    val returnInstallments: Any,

    @field:SerializedName("investor")
    val investor: InvestorSuccess,

    @field:SerializedName("loan")
    val loan: LoanSuccess,

    @field:SerializedName("paymentAgent")
    val paymentAgent: PaymentAgentSuccess,
)

data class InvestorSuccess(

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

data class LoanSuccess(

    @field:SerializedName("interestRate")
    val interestRate: Double,

    @field:SerializedName("endDate")
    val endDate: String,

    @field:SerializedName("created_at")
    val createdAt: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("totalReturnPeriod")
    val totalReturnPeriod: Int,

    @field:SerializedName("deleted_at")
    val deletedAt: Any,

    @field:SerializedName("updated_at")
    val updatedAt: String,

    @field:SerializedName("startup")
    val startup: StartupSuccess,

    @field:SerializedName("paymentPlan")
    val paymentPlan: PaymentPlanSuccess,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("targetValue")
    val targetValue: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("startDate")
    val startDate: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("withdrawn")
    val withdrawn: Boolean,

    @field:SerializedName("withdrawalInvoice")
    val withdrawalInvoice: Any,

    )

data class StartupSuccess(

    @field:SerializedName("address")
    val address: String,

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

data class PaymentPlanSuccess(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int

)

data class PaymentAgentSuccess(

    @field:SerializedName("transactionMethod")
    val transactionMethod: TransactionMethodSuccess,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)

data class TransactionMethodSuccess(

    @field:SerializedName("name")
    val name: String

)



