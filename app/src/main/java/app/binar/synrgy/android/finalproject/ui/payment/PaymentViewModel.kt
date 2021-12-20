package app.binar.synrgy.android.finalproject.ui.payment

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Constant
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.payment.PaymentTransactionRequest
import app.binar.synrgy.android.finalproject.data.payment.TransactionStatusRequest
import app.binar.synrgy.android.finalproject.model.ErrorModel
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PaymentViewModel(var sharedPreferences: SharedPreferences?) : ViewModel() {
    val showMessageAPI: MutableLiveData<String> = MutableLiveData()
    val showMessageAmount: MutableLiveData<String> = MutableLiveData()
    val showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val paymentSuccess: MutableLiveData<Boolean> = MutableLiveData(false)
    val enableTransaction: MutableLiveData<Boolean> = MutableLiveData()
    val transcationIdMut : MutableLiveData<Int> = MutableLiveData()
    val fundingIdMut : MutableLiveData<Int> = MutableLiveData()
    val paymentMethodMut : MutableLiveData<String> = MutableLiveData()
    var paymentAgentId: Int = 1
    var paymentAgentCode: String = ""
    var idtransaksi : Int? = null

    private lateinit var homeAPI: HomeAPI
    private var amount: Int ?= null
//    private var fundingID: Int = sharedPreferences?.getInt(Const.FUNDING_ID, 2)

    fun onChangeAmount(amount: Int) {
        this.amount = amount
        if (!validateAmount()) {
            showMessageAmount.value = "Your minimum amount must be at least IDR 50.000"
        } else {
            validateAmount()
        }
    }

    private fun validateAmount(amount: Int? = this.amount): Boolean {
        if (amount != null) {
            enableTransaction.value = amount >= 50_000
        }
        return enableTransaction.value == true
    }

    fun doPayment(id : Int) {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        showLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val request = PaymentTransactionRequest(
                loanId = id,
                amount = amount,
                paymentAgentId = paymentAgentId
            )
            val response = homeAPI.postPaymentTransaction("Bearer ${sharedPreferences?.getString(Constant.ACCESS_TOKEN,"")}", request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    transcationIdMut.value = response.body()?.data?.idData
                    fundingIdMut.value = id
                    paymentMethodMut.value = response.body()?.data?.paymentAgent?.name
                    Log.d("cek",response.body()?.data?.idData.toString())
                } else {
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
                    showMessageAPI.value = error.message
                    showLoading.value = false
                }
            }
        }
    }
}