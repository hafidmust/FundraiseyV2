package app.binar.synrgy.android.finalproject.ui.payment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.data.payment.PaymentGuideResponse

class DetailPaymentViewModel : ViewModel() {

    val detailPaymentGuide: MutableLiveData<List<PaymentGuideResponse>> = MutableLiveData()

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

    fun onViewLoaded(){
        detailPaymentGuide.value = dataDummyGuide
    }

}