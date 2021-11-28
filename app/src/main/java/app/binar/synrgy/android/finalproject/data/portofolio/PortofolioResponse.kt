package app.binar.synrgy.android.finalproject.data.portofolio

import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.model.PortofolioModel
import com.google.gson.annotations.SerializedName
import java.util.*

data class PortofolioResponse(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null

)

data class returnInstallment(

    @field:SerializedName("returnPeriod")
    val returnPeriod: Int? = null,

    @field:SerializedName("totalReturnPeriod")
    val totalReturnPeriod: Int? = null,

    @field:SerializedName("returnDate")
    val returnDate: Date? = null,

    @field:SerializedName("amount")
    val amount: Int? = null,

    @field:SerializedName("returnStatus")
    val returnStatus: String? = null,

    @field:SerializedName("withdrawn")
    val withdrawn: Boolean? = null,

    @field:SerializedName("id")
    val id: Int? = null

)

data class loan(

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("description")
    val description: Any? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null,

    @field:SerializedName("start_date")
    val startDate: Any? = null,

    @field:SerializedName("end_date")
    val endDate: Any? = null,

    @field:SerializedName("target_value")
    val targetValue: Int? = null,

    @field:SerializedName("interest_rate")
    val interestRate: Double? = null,

    @field:SerializedName("totalReturnPeriod")
    val totalReturnPeriod: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("withdrawn")
    val withdrawn: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("withdrawalInvoice")
    val withdrawalInvoice: Any? = null,

)

data class returnInvoice(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("bankAccount")
    val bankAccount: Any? = null,

    @field:SerializedName("paymentDate")
    val paymentDate: Any? = null

)

data class startup(

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: Any? = null,

    @field:SerializedName("logo")
    val logo: Any? = null,

    @field:SerializedName("phoneNumber")
    val phoneNumber: String? = null,

    @field:SerializedName("web")
    val web: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("foundedDate")
    val foundedDate: String? = null,

    @field:SerializedName("socialMedias")
    val socialMedias: List<Any>? = null,

    @field:SerializedName("products")
    val products: List<Any>? = null,

    @field:SerializedName("credentials")
    val credentials: List<Any>? = null,

    @field:SerializedName("startupNotifications")
    val startupNotifications: List<Any>? = null

)

data class paymentPlan(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null

)