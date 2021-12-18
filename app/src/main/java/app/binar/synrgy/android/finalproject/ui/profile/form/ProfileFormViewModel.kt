package app.binar.synrgy.android.finalproject.ui.profile.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.profile.VerificationData
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFormViewModel() : ViewModel() {
    val profileResponse : MutableLiveData<VerificationData> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    fun onViewLoaded(){
        getUserData()
    }

    fun getUserData(){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseVerification = homeAPI.getVerificationData("Bearer ${DummyBearer.auth}")

            withContext(Dispatchers.Main){
                if (responseVerification.isSuccessful){
                    profileResponse.value = responseVerification.body()?.data
                }
            }
        }
    }
}