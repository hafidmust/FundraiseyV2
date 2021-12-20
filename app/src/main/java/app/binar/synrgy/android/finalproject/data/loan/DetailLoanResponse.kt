package app.binar.synrgy.android.finalproject.data.loan

import com.google.gson.annotations.SerializedName

data class DetailLoanResponse(

    @field:SerializedName("data")
    val data: DataDetail? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class DataDetail(

    @field:SerializedName("interestRate")
    val interestRate: Int? = null,

    @field:SerializedName("endDate")
    val endDate: String? = null,

    @field:SerializedName("startup")
    val startup: Startup? = null,

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
    val currentValue: Int? = null,

    @field:SerializedName("lenderCount")
    val lenderCount: Int? = null,

    @field:SerializedName("paymentPlan")
    val paymentPlan: PaymentPlann? = null,

)

data class PaymentPlann(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("interestRate") var interestRate: Int? = null,
    @SerializedName("monthInterval") var monthInterval: Int? = null,
    @SerializedName("totalPeriod") var totalPeriod: Int? = null
)

data class paymentList(
    @SerializedName("period") var period: Int? = null,
    @SerializedName("returnDate") var returnDate: String? = null,
    @SerializedName("totalAmount") var totalAmount: Int? = null,
    @SerializedName("interestRate") var interestRate: Int? = null,
    @SerializedName("platformFee") var platformFee: Int? = null,
    @SerializedName("platformFeeRate") var platformFeeRate: Int? = null,
    @SerializedName("paid") var paid: Boolean? = null
)
