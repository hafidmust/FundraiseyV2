package app.binar.synrgy.android.finalproject.ui.homenavigation.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.history.ContentItem
import app.binar.synrgy.android.finalproject.data.history.HistoryResponse
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryViewModel : ViewModel() {
    val history : MutableLiveData<List<ContentItem>> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI
    val responseDummy: MutableLiveData<List<HistoryResponseDummy>> = MutableLiveData()

//    val history = listOf(
//        HistoryResponseDummy(
//            namaStartup = "Star Track.Inc",
//            paymentDeadline = "Sunday, 12 july 2022",
//            campaignDeadline = "Sunday, 19 Oct 2022",
//            nominalDonasi = "Rp. 500.000",
//            statusPayment = "Payment process"
//        ),
//        HistoryResponseDummy(
//            namaStartup = "Star Track.Inc",
//            paymentDeadline = "Sunday, 12 july 2022",
//            campaignDeadline = "Sunday, 19 Oct 2022",
//            nominalDonasi = "Rp. 500.000",
//            statusPayment = "Paid off"
//        ),
//        HistoryResponseDummy(
//            namaStartup = "Star Track.Inc",
//            paymentDeadline = "Sunday, 12 july 2022",
//            campaignDeadline = "",
//            nominalDonasi = "Rp. 500.000",
//            statusPayment = "Being Funded"
//        ),
//        HistoryResponseDummy(
//            namaStartup = "Star Track.Inc",
//            paymentDeadline = "Sunday, 12 july 2022",
//            campaignDeadline = "Sunday, 19 Oct 2022",
//            nominalDonasi = "Rp. 500.000",
//            statusPayment = "Late return"
//        ),
//        HistoryResponseDummy(
//            namaStartup = "Star Track.Inc",
//            paymentDeadline = "",
//            campaignDeadline = "",
//            nominalDonasi = "Rp. 500.000",
//            statusPayment = "Has returned"
//        ),
//
//        )

    fun onViewLoaded() {
        getDataHistory()
    }

    fun getDataHistory(){
     homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
     CoroutineScope(Dispatchers.IO).launch {
         val responseHistory = homeAPI.getHistory("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzODUyNTAxMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiI2ODEyNmJhOC02N2M1LTQ2ZWUtODQ2NC00NmNhMzc1ODI2ZWEiLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.BT_oWrHA4juCpxZbue9ei141wXLQ7918DECnA3Nh32Q",0,20,"id","desc")
         withContext(Dispatchers.Main){
             if (responseHistory.isSuccessful){
                 history.value = responseHistory.body()?.data?.content
             }
         }
     }
    }
}