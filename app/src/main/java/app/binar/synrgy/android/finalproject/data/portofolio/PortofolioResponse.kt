package app.binar.synrgy.android.finalproject.data.portofolio

import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.model.PortofolioModel
import com.google.gson.annotations.SerializedName
import java.util.*

data class PortofolioResponse(

    @field:SerializedName("data")
    val data: List<Data?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null

)

data class Data(

    @field:SerializedName("transactionId")
    val transactionId: Int? = null,

    @field:SerializedName("startupId")
    val startupId: Int? = null,

    @field:SerializedName("startupName")
    val startupName: String? = null,

    @field:SerializedName("loanId")
    val loanId: Int? = null,

    @field:SerializedName("loanName")
    val loanName: String? = null,

    @field:SerializedName("startDate")
    val startDate: Date? = null,

    @field:SerializedName("endDate")
    val endDate: Date? = null,

    @field:SerializedName("currentLoanValue")
    val currentLoanValue: Int? = null,

    @field:SerializedName("targetLoanValue")
    val targetLoanValue: Int? = null,

    @field:SerializedName("paymentPlanId")
    val paymentPlanId: Int? = null,

    @field:SerializedName("paymentPlanName")
    val paymentPlanName: String? = null,

)

data class returnInstallment(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("returnPeriod")
    val returnPeriod: Int? = null,

    @field:SerializedName("totalReturnPeriod")
    val totalReturnPeriod: Date? = null,

    @field:SerializedName("amount")
    val amount: Int? = null,

    @field:SerializedName("returnStatus")
    val returnStatus: String? = null,

    @field:SerializedName("returnDate")
    val returnDate: Date? = null,

    @field:SerializedName("withdrawn")
    val withdrawn: Boolean? = null,

    @field:SerializedName("returnInvoice")
    val returnInvoice: Any? = null,

)