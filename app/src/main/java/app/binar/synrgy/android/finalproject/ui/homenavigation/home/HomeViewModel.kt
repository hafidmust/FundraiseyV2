package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.home.Data
import app.binar.synrgy.android.finalproject.data.home.homeDataItem
import app.binar.synrgy.android.finalproject.data.profile.VerificationData
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class HomeViewModel : ViewModel() {
    val homeResponse : MutableLiveData<List<homeDataItem>> = MutableLiveData()
    val balanceResponse : MutableLiveData<Data> = MutableLiveData()
    val verificationResponse : MutableLiveData<VerificationData> = MutableLiveData()
    private lateinit var homeAPI : HomeAPI

    fun onViewLoaded(){
        getDataFromAPI()
        getVerification()
    }

    fun getDataFromAPI(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseAllLoan = homeAPI.getAllLoan()

            withContext(Dispatchers.Main){
                if (responseAllLoan.isSuccessful){
                    homeResponse.value = responseAllLoan.body()?.data as List<homeDataItem>?
                }
            }
        }
    }

    fun getDataBalance(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseBalance = homeAPI.getBalanceHome("Bearer ${DummyBearer.auth}")

            withContext(Dispatchers.Main){
                if (responseBalance.isSuccessful){
                    balanceResponse.value = responseBalance.body()?.data
                }
            }
        }
    }

    fun getVerification(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseVerification = homeAPI.getVerificationData("Bearer ${DummyBearer.auth}")

            withContext(Dispatchers.Main){
                if (responseVerification.isSuccessful){
                    verificationResponse.value = responseVerification.body()?.data
                }
            }
        }
    }
}