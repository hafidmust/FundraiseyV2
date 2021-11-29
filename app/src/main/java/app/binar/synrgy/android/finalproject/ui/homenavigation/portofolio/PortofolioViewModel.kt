package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponseDummy
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.data.portofolio.returnInstallment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PortofolioViewModel : ViewModel() {
    val installmentResponse: MutableLiveData<returnInstallment> = MutableLiveData()
    val loanResponse: MutableLiveData<loan> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    val responseDummy: MutableLiveData<List<PortofolioResponseDummy>> = MutableLiveData()

    val portofolio = listOf(
        PortofolioResponseDummy(
            namaStartup = "Star Track.Inc",
            totalDonasi = "500.000",
            campaignDeadline = "Sunday, 19 Oct 2022",
            nominalDonasi = "Rp. 500.000",
            statusPayment = "Payment process"
        ),
        PortofolioResponseDummy(
            namaStartup = "Star Track.Inc",
            totalDonasi = "1.500.000",
            campaignDeadline = "Sunday, 19 Oct 2022",
            nominalDonasi = "Rp. 1.500.000",
            statusPayment = "Paid off"
        ),
        PortofolioResponseDummy(
            namaStartup = "Star Track.Inc",
            totalDonasi = "1.000.000",
            campaignDeadline = "",
            nominalDonasi = "Rp. 1.000.000",
            statusPayment = "Being Funded"
        ),
        PortofolioResponseDummy(
            namaStartup = "Star Track.Inc",
            totalDonasi = "500.000",
            campaignDeadline = "Sunday, 19 Oct 2022",
            nominalDonasi = "Rp. 500.000",
            statusPayment = "Late return"
        ),
        PortofolioResponseDummy(
            namaStartup = "Star Track.Inc",
            totalDonasi = "250.000",
            campaignDeadline = "",
            nominalDonasi = "Rp. 250.000",
            statusPayment = "Has returned"
        ),
    )

    fun onViewLoaded(){
        responseDummy.value = portofolio
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio()
//            val response = homeAPI.getPortofolioTest()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataLoan()", response.body().toString())
                    println("loan -> API -> successful")
//                    loanResponse.value = response.body().
                } else {
                    Log.d("getDataLoan()", response.body().toString())
                    println("loan -> API -> failed")
                }
            }
        }
    }

    fun getDataInstallment() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataInstallment()", response.body().toString())
                    println("installment -> API -> successful")
//                    installmentResponse.value = response.body()?.data?.returnInstallment
                } else {
                    Log.d("getDataInstallment()", response.body().toString())
                    println("installment -> API -> failed")
                }
            }
        }
    }
}