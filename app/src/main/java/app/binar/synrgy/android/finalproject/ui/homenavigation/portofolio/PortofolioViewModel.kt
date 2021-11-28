package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponse
import app.binar.synrgy.android.finalproject.model.PortofolioModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PortofolioViewModel : ViewModel() {
    val portofolioModel : MutableLiveData<List<PortofolioModel>> = MutableLiveData()
    private lateinit var homeAPI : HomeAPI

    fun onViewLoaded(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataFromAPI()", response.body().toString())
                    println("hasil sukses atau panggil ke data.api")
//                    portofolioModel.value = response.body()
                } else {
                    Log.d("getDataFromAPI()", response.body().toString())
                    println("gagal get ke data.api")
                }
            }
        }
    }
}