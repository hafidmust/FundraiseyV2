package app.binar.synrgy.android.finalproject.ui.loan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.DetailLoanBinding

import app.binar.synrgy.android.finalproject.ui.payment.PaymentActivity
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper
import app.binar.synrgy.android.finalproject.utils.DaysHelper
import com.bumptech.glide.Glide

class LoanDetailsActivity : AppCompatActivity() {
    private lateinit var binding : DetailLoanBinding
    private lateinit var viewModel: LoanDetailsViewModel

    companion object{
        const val GET_ID = "get_id"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val id = intent.getIntExtra(GET_ID,0)
        Log.d("id",id.toString())
        viewModel = ViewModelProvider(this).get(LoanDetailsViewModel::class.java)
        viewModel.getDataFromAPI(id)
        viewModel.loanResponse.observe(this,{
            binding.nameProjectFunding.text = it.name
//            nominal
            binding.nominal.text = CurrencyHelper.toIdrCurrency(it.targetValue)
            binding.textFundingAmount.text = CurrencyHelper.toIdrCurrency(it.currentValue)
            binding.loanapp.text = it.name
            binding.startupcontentname.text = it.startup?.name.toString()
            binding.tvcontentaboutstartup.text = it.description.toString()
            binding.tvDetailAboutStartup.text = it.startup?.description.toString()
//            get remaining day
            binding.tvremainingday.text = DaysHelper.getDaysHelper(it.startDate.toString(), it.endDate.toString()) +" day left"
//            progress
            binding.progressFunding.max = it.targetValue!!
            binding.progressFunding.progress = it.currentValue!!
            Glide.with(binding.root)
                .load(it.startup?.logo.toString())
                .into(binding.icLogoLoaninformation)
            binding.addressstartup.text = it.startup?.address.toString()
            binding.tvContentWeb.text = it.startup?.web.toString()
            binding.tvContentPhone.text = it.startup?.phoneNumber.toString()
            binding.contentsince.text = it.startup?.foundedDate.toString()
            binding.tvFundingAmountNominal.text = it.lenderCount.toString()

        })
        viewModel.getDataStartup(id)
//        viewModel.startupResponse.observe(this,{
//            binding.startupcontentname.text = it.name.toString()
//            binding.tvDetailAboutStartup.text = it.description.toString()
//
//        })
        binding.cardviewAddressstartup.setOnClickListener{
            // TODO: 11/29/2021
        }
        binding.buttonFundNow.setOnClickListener {
            startActivity(Intent(this,PaymentActivity::class.java))
        }
    }
}