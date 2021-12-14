package app.binar.synrgy.android.finalproject.ui.payment

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.payment.PaymentTransactionRequest
import app.binar.synrgy.android.finalproject.data.payment.TransactionStatusRequest
import app.binar.synrgy.android.finalproject.data.payment.bankList
import app.binar.synrgy.android.finalproject.model.ErrorModel
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PaymentViewModel(sharedPreferences: SharedPreferences) : ViewModel() {
    val bankList: MutableLiveData<List<bankList>> = MutableLiveData()
    val showMessageAPI: MutableLiveData<String> = MutableLiveData()
    val showMessageAmount: MutableLiveData<String> = MutableLiveData()
    val showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val paymentSuccess: MutableLiveData<Boolean> = MutableLiveData(false)
    val enableTransaction: MutableLiveData<Boolean> = MutableLiveData()
    var paymentAgentId: Int = 1
    var paymentAgentCode: String = ""

    private lateinit var homeAPI: HomeAPI
    private var amount: Int = 0
    private var transactionId = (10_000..90_000).random()
    private var fundingID: Int = sharedPreferences.getInt(Const.FUNDING_ID, 2)

    fun onChangeAmount(amount: Int) {
        this.amount = amount
        if (!validateAmount()) {
            showMessageAmount.value = "Your minimum amount must be at least IDR 50.000"
        } else {
            validateAmount()
        }
    }

    private fun validateAmount(amount: Int = this.amount): Boolean {
        enableTransaction.value = amount >= 50_000
        return enableTransaction.value == true
    }

    fun doPayment() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        showLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val request = PaymentTransactionRequest(
                loanId = fundingID,
                amount = amount,
                paymentAgentId = paymentAgentId
            )
            val response = homeAPI.postPaymentTransaction("Bearer ${DummyBearer.auth}", request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    if (response.body()?.status == 403) {
                        showMessageAPI.value = response.body()!!.message
                        showLoading.value = false
                    }
                } else {
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
                    showMessageAPI.value = error.message
                    showLoading.value = false
                }
            }
        }
    }

    fun doPaymentStatus() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        showLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val request = TransactionStatusRequest(
                transactionId = fundingID
            )
            val response = homeAPI.postTransactionStatus("Bearer ${DummyBearer.auth}", request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    if (response.body()?.status == 403) {
                        showMessageAPI.value = response.body()!!.message
                        showLoading.value = false
                    }
                } else {
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
                    showMessageAPI.value = error.message
                    showLoading.value = false
                }
                paymentSuccess.value = true
            }
        }
    }
}