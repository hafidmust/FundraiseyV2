package app.binar.synrgy.android.finalproject.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy

class HistoryViewModel : ViewModel() {
    val responseDummy : MutableLiveData<List<HistoryResponseDummy>> = MutableLiveData()

    val history = listOf(HistoryResponseDummy(
        namaStartup = "Star Track.Inc",
        paymentDeadline = "Sunday, 12 july 2022",
        campaignDeadline = "Sunday, 19 Oct 2022",
        nominalDonasi = "Rp. 500.000",
        statusPayment = "Payment process"
    ))
    fun onViewLoaded(){
        responseDummy.value = history
    }
}