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
            binding.nameProjectFunding.text = it.name
            binding.nominal.text = it.targetValue.toString()
            binding.loanapp.text = it.name
            binding.tvcontentaboutstartup.text = it.description.toString()
            binding.nominal.text = it.currentValue.toString()

        })
//        binding.buttonUploadReceipt.setOnClickListener {
//            dialog.uploadReceiptDialog(true)
//            Handler(Looper.getMainLooper()).postDelayed({
//                finish()
//            },5000)
//        }
    }
}