package app.binar.synrgy.android.finalproject.data.api.signIn

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("grant_type") var grantType: String,
    @SerializedName("client_id") var clientId: String,
    @SerializedName("client_secret") var clientSecret: String,

)
