package app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.history.DataDetail


import app.binar.synrgy.android.finalproject.data.loan.Startup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailHistoryViewModel : ViewModel() {

    val loanResponse : MutableLiveData<DataDetail> = MutableLiveData()
//    val startupResponse : MutableLiveData<Startup> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    fun getDataFromAPI(id : Int){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseLoanDetail = homeAPI.getHistoryDetail("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzODc4NjY4NiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiI2MDJiODNlMS1kM2VjLTQyNDctYmE5MS0xMWM0NjY4NzVkOWQiLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.r9B736XAFWGVdxJPOTD9zfrcdFQeUdee0w4sAmZTGAs",id)
            withContext(Dispatchers.Main){
                if (responseLoanDetail.isSuccessful){
                    loanResponse.value = responseLoanDetail.body()?.data
                }
            }
        }
    }

//    fun getDataStartup(id : Int){
//        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val responseLoanDetail = homeAPI.getLoanDetail(id)
//            withContext(Dispatchers.Main){
//                if (responseLoanDetail.isSuccessful){
//                    startupResponse.value = responseLoanDetail.body()?.data?.startup
//                }
//            }
//        }
//    }
}