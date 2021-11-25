package app.binar.synrgy.android.finalproject.ui.loan

import androidx.lifecycle.MutableLiveData
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.data.loan.LoanResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoanDetailsViewModel {
    val loanResponse : MutableLiveData<List<DataItem>> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    fun onViewLoaded(){
        getDataFromAPI()
    }

    fun getDataFromAPI(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseLoanDetail = homeAPI.getLoanDetail()

            withContext(Dispatchers.Main){
                if (responseLoanDetail.isSuccessful){
                    loanResponse.value = responseLoanDetail.body()?.data as List<DataItem>
                }
            }
        }
    }
}