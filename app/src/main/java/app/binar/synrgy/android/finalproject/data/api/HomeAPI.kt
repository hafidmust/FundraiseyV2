package app.binar.synrgy.android.finalproject.data.api

import app.binar.synrgy.android.finalproject.data.api.signIn.SignInRequest
import app.binar.synrgy.android.finalproject.data.api.signIn.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeAPI {

    @POST("users/login")
    suspend fun postSignIn(@Body request: SignInRequest): Response<SignInResponse>

    companion object {

    }
}