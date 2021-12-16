package app.binar.synrgy.android.finalproject.ui.payment.detail

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.ActivityDetailPaymentBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail.DetailHistoryActivity
import app.binar.synrgy.android.finalproject.ui.payment.dialog.PopupDialog
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper

class DetailPaymentActivity() : AppCompatActivity() {
    private lateinit var detailPaymentViewModel: DetailPaymentViewModel
    private lateinit var binding : ActivityDetailPaymentBinding
    private val dialog by lazy { PopupDialog(this) }

    var status: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val sharedPreferences = getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)
        detailPaymentViewModel = DetailPaymentViewModel()
        val id = sharedPreferences.getInt(Const.FUNDING_ID,  0)
        Log.d("id", id.toString())

        detailPaymentViewModel = ViewModelProvider(this).get(DetailPaymentViewModel::class.java)
        detailPaymentViewModel.getDataFromAPI(id)
        detailPaymentViewModel.loanResponse.observe(this, {
            binding.tvvirtualnumber.text = it.accountNumber
            binding.tvjumlahtagihan.text = CurrencyHelper.toIdrCurrency(it.amount)
            binding.tvDeadlineTimestamp.text = it.paymentDeadline
            when{
                it.paymentAgent.equals(1) -> binding.tvBca.text = "BCA Virtual Account"
                it.paymentAgent.equals(2) -> binding.tvBca.text = "Mandiri Virtual Account"
                it.paymentAgent.equals(3) -> binding.tvBca.text = "OVO Virtual Account"
                it.paymentAgent.equals(4) -> binding.tvBca.text = "GOPAY Virtual Account"
            }
            status = it.transactionStatus
        })

        binding.copy.setOnClickListener {
            copyVAN()
        }
        binding.copy2.setOnClickListener {
            copyVAN()
        }

        binding.btnOtherInvesment.setOnClickListener {
            dialog.showDialog(true)
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,HomeNavigationActivity::class.java))
                finish()
            },5000)
        }
        binding.btnCheckInvestmentStatus.setOnClickListener {
            startActivity(
                Intent(this, DetailHistoryActivity::class.java).apply {
                    putExtra(DetailHistoryActivity.GET_ID, sharedPreferences.getInt(Const.FUNDING_ID, 2))
                    putExtra(DetailHistoryActivity.GET_STATUS, status)
                }
            )
        }
    }

    private fun copyVAN() {
        val tvToCopy = binding.tvvirtualnumber.text.toString()
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", tvToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(this, "Copied to clipboard",Toast.LENGTH_SHORT).show()
    }
}