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
            val responseLoanDetail = homeAPI.getHistoryDetail("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzODk4OTUwMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiI4MjY2NmM4My0wZDRhLTRkZWYtOTQwNi1jMTU2Yzk1NTdlYTkiLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.9YsOc6ZNousIpQn3rG4aK6AWUy-vpfkd6mYeQ46R7p8",id)
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