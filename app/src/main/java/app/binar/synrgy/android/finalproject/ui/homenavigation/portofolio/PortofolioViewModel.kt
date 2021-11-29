package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponse
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.data.portofolio.returnInstallment
import app.binar.synrgy.android.finalproject.model.PortofolioModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PortofolioViewModel : ViewModel() {
    val installmentResponse: MutableLiveData<returnInstallment> = MutableLiveData()
    val loanResponse: MutableLiveData<loan> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    fun onViewLoaded(){
        getDataLoan()
        getDataInstallment()
    }

    fun getDataLoan() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataLoan()", response.body().toString())
                    println("loan -> API -> successful")
                    loanResponse.value = response.body()?
                } else {
                    Log.d("getDataLoan()", response.body().toString())
                    println("loan -> API -> failed")
                }
            }
        }
    }

    fun getDataInstallment() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.getPortofolio()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataInstallment()", response.body().toString())
                    println("installment -> API -> successful")
                    installmentResponse.value = response.body()?.data?.returnInstallment
                } else {
                    Log.d("getDataInstallment()", response.body().toString())
                    println("installment -> API -> failed")
                }
            }
        }
    }
}