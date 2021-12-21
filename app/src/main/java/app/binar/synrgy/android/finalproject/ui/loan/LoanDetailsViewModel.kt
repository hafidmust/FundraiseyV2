package app.binar.synrgy.android.finalproject.ui.loan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI

import app.binar.synrgy.android.finalproject.data.loan.DataDetail
import app.binar.synrgy.android.finalproject.data.loan.LoanResponse
import app.binar.synrgy.android.finalproject.data.loan.Startup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoanDetailsViewModel : ViewModel() {
    val loanResponse : MutableLiveData<DataDetail> = MutableLiveData()
    val startupResponse : MutableLiveData<Startup> = MutableLiveData()
    val isLoanAvailable : MutableLiveData<Boolean> = MutableLiveData(false)
    private lateinit var homeAPI: HomeAPI

    fun getDataFromAPI(id : Int){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseLoanDetail = homeAPI.getLoanDetail(id)
            withContext(Dispatchers.Main){
                if (responseLoanDetail.isSuccessful){
                    loanResponse.value = responseLoanDetail.body()?.data
                }
            }
        }
    }
    
    fun getDataStartup(id : Int){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseLoanDetail = homeAPI.getLoanDetail(id)
            withContext(Dispatchers.Main){
                if (responseLoanDetail.isSuccessful){
                    startupResponse.value = responseLoanDetail.body()?.data?.startup
                }
            }
        }
    }

}