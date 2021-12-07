package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.home.Data
import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.data.home.HomeBalanceResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val homeResponse : MutableLiveData<List<DataItem>> = MutableLiveData()
    val balanceResponse : MutableLiveData<Data> = MutableLiveData()
    private lateinit var homeAPI : HomeAPI

    fun onViewLoaded(){
        getDataFromAPI()
    }

    fun getDataFromAPI(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseAllLoan = homeAPI.getAllLoan()

            withContext(Dispatchers.Main){
                if (responseAllLoan.isSuccessful){
                    homeResponse.value = responseAllLoan.body()?.data as List<DataItem>?
                }
            }
        }
    }

    fun getDataBalance(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseBalance = homeAPI.getBalanceHome("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzODg2ODEyNCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiJjZTQ1NTBmNC1jZWNiLTQyMDAtYTIzNy1lY2MyODAzMmVmMWMiLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.upfl0n25kdNV9QdVm8Q_TuXdl4k6fcmZ6B5JgAR547E")

            withContext(Dispatchers.Main){
                if (responseBalance.isSuccessful){
                    balanceResponse.value = responseBalance.body()?.data
                }
            }
        }
    }
}