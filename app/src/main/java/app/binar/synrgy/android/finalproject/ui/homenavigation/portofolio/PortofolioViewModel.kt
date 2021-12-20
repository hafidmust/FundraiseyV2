package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Constant

import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.home.Data
import app.binar.synrgy.android.finalproject.data.portofolio.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PortofolioViewModel(val sharedPreferences: SharedPreferences?) : ViewModel() {
    val loanResponse: MutableLiveData<List<DataItem>> = MutableLiveData()
    val summaryResponse: MutableLiveData<summary> = MutableLiveData()
    val balanceResponse: MutableLiveData<Data> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

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

    fun onViewLoaded() {
        getDataBalance()
        getDataSummary()
        getDataAdapter()
    }

    fun withdrawAllFunds() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                homeAPI.withdrawAllFunds("Bearer ${sharedPreferences?.getString(Constant.ACCESS_TOKEN,"")}")
            }
        }
    }

    fun getDataAdapter() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio(
                "Bearer ${sharedPreferences?.getString(Constant.ACCESS_TOKEN,"")}"
            )
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    println("loan -> API -> successful")
                    loanResponse.value = response.body()?.data as List<DataItem>
                } else {
                    println("loan -> API -> failed")
                }
            }
        }
    }

    fun getDataSummary() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseSummary = homeAPI.getPortofolioSummary("Bearer ${sharedPreferences?.getString(
                Constant.ACCESS_TOKEN,"")}")

            withContext(Dispatchers.Main) {
                if (responseSummary.isSuccessful) {
                    summaryResponse.value = responseSummary.body()?.data
                }
            }
        }
    }

    fun getDataBalance() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseBalance = homeAPI.getBalanceHome("Bearer ${sharedPreferences?.getString(Constant.ACCESS_TOKEN,"")}")

            withContext(Dispatchers.Main) {
                if (responseBalance.isSuccessful) {
                    balanceResponse.value = responseBalance.body()?.data
                }
            }
        }
    }
}