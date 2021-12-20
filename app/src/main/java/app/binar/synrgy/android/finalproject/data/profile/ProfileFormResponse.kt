package app.binar.synrgy.android.finalproject.data.profile

import com.google.gson.annotations.SerializedName

data class ProfileFormResponse(

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int

)
