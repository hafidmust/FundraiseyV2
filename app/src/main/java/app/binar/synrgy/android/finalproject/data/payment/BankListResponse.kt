package app.binar.synrgy.android.finalproject.data.payment

import com.google.gson.annotations.SerializedName

data class BankListResponse(

    @field:SerializedName("data")
    val data: List<bankList?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null

)

data class bankList(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("bankCode")
    val bankCode: String? = null,

)

