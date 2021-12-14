package app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.HistoryDetailBinding
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
        const val GET_STATUS = "get_status"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val id = intent.getIntExtra(GET_ID, 0)
        Log.d("id", id.toString())
        val statusPay = intent.getStringExtra(GET_STATUS)
        Log.d("coba", statusPay.toString())

        viewModel = ViewModelProvider(this).get(DetailHistoryViewModel::class.java)
        viewModel.getDataFromAPI(id)
        viewModel.loanResponse.observe(this, {
            binding.nameProjectFunding.text = it.loan.name
            binding.nominal.text = CurrencyHelper.toIdrCurrency(it.amount)
//            binding.progressFunding.max = it.loan.targetValue
//            binding.progressFunding.progress = it.amount
            binding.tvfundingall.text = CurrencyHelper.toIdrCurrency(it.loan.targetValue)
            binding.tvDate.text = it.paymentDeadline
            binding.tvvirtualnumber.text = it.accountNumber
            binding.tvjumlahtagihan.text = CurrencyHelper.toIdrCurrency(it.amount)
            binding.tvAmountLoan.text = CurrencyHelper.toIdrCurrency(it.amount)
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
            binding.tvContentLinkedin.text = "-"
            binding.tvContentInstagram.text = "-"
            binding.tvContentfb.text = "-"
            binding.tvNamaBank.text = it.paymentAgent.name
            binding.tvCopyVa.setOnClickListener {

            }

//            binding.loanapp.text = it.name
//            binding.tvcontentaboutstartup.text = it.description.toString()
//            binding.nominal.text = it.currentValue.toString()

        })
        when(statusPay){
            "pending" ->{
                binding.viewlate.visibility = View.GONE
                binding.tvlatepayment.visibility = View.GONE
            }
            "paid" -> {
                binding.constraintpembayaran.visibility = View.GONE
                binding.viewlate.visibility = View.GONE
                binding.tvlatepayment.visibility = View.GONE
            }
            "unpaid" -> {
                binding.constraintpembayaran.visibility = View.VISIBLE
                binding.viewlate.visibility = View.VISIBLE
                binding.tvlatepayment.visibility = View.VISIBLE
            }
        }

//        binding.buttonUploadReceipt.setOnClickListener {
//            dialog.uploadReceiptDialog(true)
//            Handler(Looper.getMainLooper()).postDelayed({
//                finish()
//            },5000)
//        }
    }
}