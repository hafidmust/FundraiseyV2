package app.binar.synrgy.android.finalproject.data.api

import app.binar.synrgy.android.finalproject.data.api.signIn.SignInRequest
import app.binar.synrgy.android.finalproject.data.api.signIn.SignInResponse
import app.binar.synrgy.android.finalproject.data.api.signup.SignUpRequest
import app.binar.synrgy.android.finalproject.data.api.signup.SignUpResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeAPI {

    @POST("v1/login")
    suspend fun postSignIn(@Body request: SignInRequest): Response<SignInResponse>

    @POST("/v1/register-investor")
    suspend fun postSignUp(@Body request : SignUpRequest) : Response<SignUpResponse>

    companion object {
        fun getInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://fundraisey-api-staging.herokuapp.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
