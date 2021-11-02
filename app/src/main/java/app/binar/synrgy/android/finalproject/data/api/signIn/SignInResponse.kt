package app.binar.synrgy.android.finalproject.data.api.signIn

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("email") var email : String,
    @SerializedName("password") var password : String,
    @SerializedName("grant_type") var grant_type : String,
    @SerializedName("client_id") var client_id : String,
    @SerializedName("client_secret") var client_secret : String
)