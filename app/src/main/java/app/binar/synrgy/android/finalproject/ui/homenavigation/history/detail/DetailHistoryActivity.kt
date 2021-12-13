package app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.DetailLoanBinding
import app.binar.synrgy.android.finalproject.databinding.HistoryDetailBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.ui.loan.LoanDetailsViewModel
import app.binar.synrgy.android.finalproject.ui.payment.PaymentActivity
import app.binar.synrgy.android.finalproject.ui.payment.dialog.PopupDialog
import app.binar.synrgy.android.finalproject.utils.CopyHelper
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper
import app.binar.synrgy.android.finalproject.utils.DaysHelper
import com.bumptech.glide.Glide
import okhttp3.internal.wait


class DetailHistoryActivity : AppCompatActivity() {
    private lateinit var binding: HistoryDetailBinding
    private lateinit var viewModel: DetailHistoryViewModel
    private val dialog by lazy { PopupDialog(this) }

    companion object {
        const val GET_ID = "get_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val id = intent.getIntExtra(GET_ID, 0)
        Log.d("id", id.toString())
        viewModel = ViewModelProvider(this).get(DetailHistoryViewModel::class.java)
        viewModel.getDataFromAPI(id)
        viewModel.loanResponse.observe(this, {
            binding.nameProjectFunding.text = it.loan.name
            binding.nominal.text = CurrencyHelper.toIdrCurrency(it.amount)
//            binding.progressFunding.max = it.loan.targetValue
//            binding.progressFunding.progress = it.amount
            binding.tvfundingall.text = CurrencyHelper.toIdrCurrency(it.loan.targetValue)
            binding.tvDate.text = DaysHelper.dateFormatter(it.paymentDeadline)
            binding.tvvirtualnumber.text = it.accountNumber
            binding.tvjumlahtagihan.text = CurrencyHelper.toIdrCurrency(it.amount)
            binding.tvAmountLoan.text = it.amount.toString()
            binding.loanapp.text = it.loan.name
            binding.textStartUpName.text = it.loan.startup.name
            binding.tvcontentaboutstartup.text = it.loan.description
            binding.tvDetailAboutStartup.text = it.loan.startup.description
            binding.contentaddress.text = it.loan.startup.address
            Glide.with(binding.root)
                .load(it.loan.startup.logo)
                .into(binding.icLogoLoaninformation)
            binding.tvContentWeb.text = it.loan.startup.web
            binding.tvContentPhone.text = it.loan.startup.phoneNumber
            binding.tvContentLinkedin.text = it.loan.startup.linkedin
            binding.tvContentInstagram.text = it.loan.startup.instagram
            binding.tvNamaBank.text = it.paymentAgent.name
            binding.tvCopyVa.setOnClickListener {

            }



//            binding.loanapp.text = it.name
//            binding.tvcontentaboutstartup.text = it.description.toString()
//            binding.nominal.text = it.currentValue.toString()

        })
//        binding.buttonUploadReceipt.setOnClickListener {
//            dialog.uploadReceiptDialog(true)
//            Handler(Looper.getMainLooper()).postDelayed({
//                finish()
//            },5000)
//        }
    }
}