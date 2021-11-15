package app.binar.synrgy.android.finalproject.data.api.signIn

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)
