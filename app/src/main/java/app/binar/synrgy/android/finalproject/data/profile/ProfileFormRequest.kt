package app.binar.synrgy.android.finalproject.data.profile

import com.google.gson.annotations.SerializedName

data class ProfileFormRequest(

    @field:SerializedName("citizenID")
    val citizenID: String,

    @field:SerializedName("fullName")
    val fullName: String,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("phoneNumber")
    val phoneNumber: String,

    @field:SerializedName("dateOfBirth")
    val dateOfBirth: String,

    @field:SerializedName("bankAccountNumber")
    val bankAccountNumber: String,

)
