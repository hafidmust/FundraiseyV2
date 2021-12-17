package app.binar.synrgy.android.finalproject.ui.payment.detail

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.payment.DataDetail
import app.binar.synrgy.android.finalproject.data.payment.PaymentGuideResponse
import app.binar.synrgy.android.finalproject.data.payment.TransactionStatusRequest
import app.binar.synrgy.android.finalproject.model.ErrorModel
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailPaymentViewModel(var sharedPreferences: SharedPreferences) : ViewModel() {

    val detailPaymentGuide: MutableLiveData<List<PaymentGuideResponse>> = MutableLiveData()
    val loanResponse : MutableLiveData<DataDetail> = MutableLiveData()
    val successPay : MutableLiveData<Boolean> = MutableLiveData(false)

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

    fun getTransaction(id : Int){
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
    fun doPaymentStatus(transa : Int) {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val request = TransactionStatusRequest(
                transactionId = transa
            )
            val response = homeAPI.postTransactionStatus("Bearer ${DummyBearer.auth}", request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    if (response.body()?.status == 200){
                        successPay.value = true
                    }

//                    if (response.body()?.status == 403) {
//                        showMessageAPI.value = response.body()!!.message
//                        showLoading.value = false
//                    }

                } else {
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
//                    showMessageAPI.value = error.message
//                    showLoading.value = false
                }
            }
        }
    }

    fun onViewLoaded(){
        detailPaymentGuide.value = dataDummyGuide
    }
}