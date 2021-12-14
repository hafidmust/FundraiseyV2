package app.binar.synrgy.android.finalproject.ui.homenavigation.history

import app.binar.synrgy.android.finalproject.data.local.HistoryCache
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.history.ContentItem
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy
import app.binar.synrgy.android.finalproject.data.local.AppDatabase
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryViewModel(private val appDatabase: AppDatabase) : ViewModel() {
    val history: MutableLiveData<List<ContentItem>> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI
    val responseDummy: MutableLiveData<List<HistoryResponseDummy>> = MutableLiveData()


    fun onViewLoaded() {
        getDataHistory()
    }

    fun getDataHistory(){
     homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
     CoroutineScope(Dispatchers.IO).launch {
         val responseHistory = homeAPI.getHistory("Bearer ${DummyBearer.auth}")
         withContext(Dispatchers.Main){
             if (responseHistory.isSuccessful){
                 history.value = responseHistory.body()?.data?.content
                 responseHistory.body()?.data?.content?.let { insertHistory(it) }
             }
         }
     }
    }
    fun insertHistory(response: List<ContentItem>){
        response?.let {
            CoroutineScope(Dispatchers.IO).launch {
                val history : List<HistoryCache> = it.map { history ->
                    HistoryCache(
                        id = history.id.toString(),
                        nameLoan = history.loan.name,
                    amountFund = history.amount,
                    paymentDeadline = history.paymentDeadline,
                    campaignDeadline = history.loan.endDate,
                    statusPayment = history.transactionStatus,
                    nameStartup = history.loan.startup.name)
                }
                appDatabase.homeDao().insertAllHistory(*history.toTypedArray())
            }
        }
    }
}