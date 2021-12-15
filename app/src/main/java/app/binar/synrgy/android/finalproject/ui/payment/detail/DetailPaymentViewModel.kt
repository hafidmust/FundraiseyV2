package app.binar.synrgy.android.finalproject.ui.payment.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.payment.DataDetail
import app.binar.synrgy.android.finalproject.data.payment.PaymentGuideResponse
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailPaymentViewModel : ViewModel() {

    val detailPaymentGuide: MutableLiveData<List<PaymentGuideResponse>> = MutableLiveData()
    val loanResponse : MutableLiveData<DataDetail> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    val dataDummyGuide = listOf(
        PaymentGuideResponse(
            image = R.drawable.rv1
        ),
        PaymentGuideResponse(
            image = R.drawable.rv2
        ),
        PaymentGuideResponse(
            image = R.drawable.rv3
        ),
        PaymentGuideResponse(
            image = R.drawable.rv4
        ),
        )

    fun getDataFromAPI(id : Int){
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseLoanDetail = homeAPI.getPaymentDetail("Bearer ${DummyBearer.auth}",id)
            withContext(Dispatchers.Main){
                if (responseLoanDetail.isSuccessful){
                    loanResponse.value = responseLoanDetail.body()?.data
                }
            }
        }
    }

    fun onViewLoaded(){
        detailPaymentGuide.value = dataDummyGuide
    }
}