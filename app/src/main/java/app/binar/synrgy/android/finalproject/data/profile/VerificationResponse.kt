package app.binar.synrgy.android.finalproject.data.profile

import app.binar.synrgy.android.finalproject.data.portofolio.DataItem
import com.google.gson.annotations.SerializedName

data class VerificationResponse(

    @field:SerializedName("data")
    val data: VerificationData,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int

)

data class VerificationData(

    @field:SerializedName("loanId")
    val loanId: Int,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("citizenID")
    val citizenID: String,

    @field:SerializedName("fullName")
    val fullName: String,

    @field:SerializedName("phoneNumber")
    val phoneNumber: String,

    @field:SerializedName("bankAccountNumber")
    val bankAccountNumber: String,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("dateOfBirth")
    val dateOfBirth: String,

    @field:SerializedName("verified")
    val verified: Boolean

)
