package app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.constant.Constant
import app.binar.synrgy.android.finalproject.databinding.HistoryDetailBinding
import app.binar.synrgy.android.finalproject.ui.payment.dialog.PopupDialog
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper
import com.bumptech.glide.Glide

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

        val sharedPreferences = this.getSharedPreferences(Constant.PREF_NAME, MODE_PRIVATE)
        viewModel = DetailHistoryViewModel(sharedPreferences)
        viewModel.getDataFromAPI(id)
        viewModel.loanResponse.observe(this, {
            binding.nameProjectFunding.text = it.loan.name
            binding.nominal.text = CurrencyHelper.toIdrCurrency(it.amount)
            binding.imgBack.setOnClickListener { onBackPressed() }
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
            binding.tvInterest.text = "(${it.interestRate}% Interest)"
//            binding.contentreturningmethod.text = it.paymentPlan.id
            when(it.loan.paymentPlan.totalPeriod){
                1 -> {
                    binding.contentreturningmethod.text = "Cash Payment"
                    binding.tvMonthInstallment.text = "Cash Payment"
                }
                2 -> {
                    binding.contentreturningmethod.text = "1 years installment"
                    binding.tvMonthInstallment.text = "1 years installment"

                }
                4 -> {
                    binding.contentreturningmethod.text = "6 month installment"
                    binding.tvMonthInstallment.text = "6 month installment"

                }
            }
            binding.tvCopyVa.setOnClickListener {

            }
            binding.tvCopyVa.setOnClickListener {
                copyVAN()
            }
            binding.tvCopyTagihan.setOnClickListener {
                copyVAN()
            }
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
    }
    private fun copyVAN() {
        val tvToCopy = binding.tvvirtualnumber.text.toString()
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", tvToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show()
    }
}