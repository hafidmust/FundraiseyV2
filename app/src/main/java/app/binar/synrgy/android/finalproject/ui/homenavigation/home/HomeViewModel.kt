package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.home.DataItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val homeResponse : MutableLiveData<List<DataItem>> = MutableLiveData()
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
}