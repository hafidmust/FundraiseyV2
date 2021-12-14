package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.portofolio.Data
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponseDummy
import app.binar.synrgy.android.finalproject.data.portofolio.returnInstallment
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PortofolioViewModel : ViewModel() {
    val loanResponse: MutableLiveData<List<Data>> = MutableLiveData()
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
        //responseDummy.value = portofolio
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio(
                "Bearer ${DummyBearer.auth}",
                0,
                20,
                "id",
                "desc"
            )
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataLoan()", response.body().toString())
                    println("loan -> API -> successful")
                    loanResponse.value = response.body()?.data as List<Data>
                } else {
                    Log.d("getDataLoan()", response.body().toString())
                    println("loan -> API -> failed")
                }
            }
        }
    }

//    fun getDataInstallment() {
//        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = homeAPI.getPortofolio("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzODg5NDY2NCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiJiZmMxYWU2NS02OWM5LTRlYmItODc0Mi0xM2Y3ODA5NzU0NDgiLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.4abQPwy1tYJ0-sG2P0gipx8c_VL_R0BOrOMooCLNNQM",0,20,"id","desc")
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//                    Log.d("getDataInstallment()", response.body().toString())
//                    println("installment -> API -> successful")
//                    installmentResponse.value = response.body()?.data as List<returnInstallment>
//                } else {
//                    Log.d("getDataInstallment()", response.body().toString())
//                    println("installment -> API -> failed")
//                }
//            }
//        }
//    }
}