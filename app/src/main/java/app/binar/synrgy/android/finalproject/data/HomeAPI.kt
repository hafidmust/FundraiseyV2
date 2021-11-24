package app.binar.synrgy.android.finalproject.data

import app.binar.synrgy.android.finalproject.data.home.HomeLoanResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HomeAPI {
    companion object{
        fun getInstance() : Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://fundraisey-api-staging.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
        }
    }
    @GET("/v1/loan/all")
//    import ?
    suspend fun getAllLoan() : Response<HomeLoanResponse>

}