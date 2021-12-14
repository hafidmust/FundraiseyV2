package app.binar.synrgy.android.finalproject.data.loan

import app.binar.synrgy.android.finalproject.data.home.homeDataItem
import app.binar.synrgy.android.finalproject.data.home.homeStartup
import com.google.gson.annotations.SerializedName

data class LoanResponse(

    @field:SerializedName("data")
    val data: List<homeDataItem?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null

)

data class DataItem(

    @field:SerializedName("interestRate")
    val interestRate: Double? = null,

    @field:SerializedName("endDate")
    val endDate: String? = null,

    @field:SerializedName("startup")
    val startup: homeStartup? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("targetValue")
    val targetValue: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("startDate")
    val startDate: String? = null,

    @field:SerializedName("currentValue")
    val currentValue: Int? = null
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

data class paymentPlan(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null

)