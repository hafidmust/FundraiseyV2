package app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Constant
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.history.DataDetail


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailHistoryViewModel(val sharedPreferences: SharedPreferences?) : ViewModel() {

    val loanResponse : MutableLiveData<DataDetail> = MutableLiveData()
//    val startupResponse : MutableLiveData<Startup> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    fun getDataFromAPI(id : Int){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseLoanDetail = homeAPI.getHistoryDetail("Bearer ${sharedPreferences?.getString(
                Constant.ACCESS_TOKEN,"")}",id)
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