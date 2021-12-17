package app.binar.synrgy.android.finalproject.ui.profile

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.profile.VerificationData
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel() : ViewModel() {
    val verificationResponse : MutableLiveData<VerificationData> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    fun onViewLoaded(){
        getVerification()
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