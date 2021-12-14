package app.binar.synrgy.android.finalproject.data

import app.binar.synrgy.android.finalproject.data.history.DetailHistoryResponse
import app.binar.synrgy.android.finalproject.data.history.HistoryResponse
import app.binar.synrgy.android.finalproject.data.home.HomeBalanceResponse
import app.binar.synrgy.android.finalproject.data.home.HomeLoanResponse
import app.binar.synrgy.android.finalproject.data.loan.DetailLoanResponse
import app.binar.synrgy.android.finalproject.data.payment.*
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponse
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioSummaryResponse
import app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio.AdapterPortofolio
import app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio.PortofolioViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface HomeAPI {
    companion object {
        fun getInstance(): Retrofit {
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
    suspend fun getAllLoan(): Response<HomeLoanResponse>

    @GET("/v1/loan/detail/{id}")
    suspend fun getLoanDetail(
        @Path("id")
        id: Int
    ): Response<DetailLoanResponse>

    @GET("/v1/investor/loan/portofolio")
    suspend fun getPortofolio(
        @Header("Authorization") auth : String
    ): Response<PortofolioResponse>


    @GET("v1/investor/transaction/all")
    suspend fun getHistory(
        @Header("Authorization") auth : String
    ) : Response<HistoryResponse>

    @GET("/v1/investor/transaction/{id}")
    suspend fun getHistoryDetail(
        @Header("Authorization") auth : String,
        @Path("id") id : Int
    ) : Response<DetailHistoryResponse>

    @GET("/v1/investor/loan/portofolio-summary")
    suspend fun getBalanceHome(
        @Header("Authorization") authorization : String
    ) : Response<HomeBalanceResponse>

    @GET("/v1/investor/loan/portofolio-summary")
    suspend fun getPortofolioSummary(
        @Header("Authorization") authorization : String
    ) : Response<PortofolioSummaryResponse>

    @GET("/v1/startup/loan/withdraw/bank-list")
    suspend fun getBankList(
        @Header("Authorization") authorization : String
    ) : Response<BankListResponse>

    @POST("/v1/investor/transaction/insert")
    suspend fun postPaymentTransaction(
        @Header("Authorization") authorization : String,
        @Body request : PaymentTransactionRequest) : Response<PaymentTransactionResponse>

    @POST("/v1/investor/transaction/pay")
    suspend fun postTransactionStatus(
        @Header("Authorization") authorization : String,
        @Body request : TransactionStatusRequest) : Response<TransactionStatusResponse>

}