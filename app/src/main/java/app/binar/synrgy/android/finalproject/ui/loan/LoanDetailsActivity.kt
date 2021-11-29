package app.binar.synrgy.android.finalproject.ui.loan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.DetailLoanBinding

import app.binar.synrgy.android.finalproject.ui.payment.PaymentActivity

class LoanDetailsActivity : AppCompatActivity() {
    private lateinit var binding : DetailLoanBinding
    private lateinit var viewModel: LoanDetailsViewModel

    companion object{
        const val GET_ID = "get_id"
    }

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
            binding.nominal.text = "Rp. " + it.targetValue.toString()
            binding.loanapp.text = it.name
            binding.tvcontentaboutstartup.text = it.description.toString()
            binding.textFundingAmount.text = "Rp. " + it.currentValue.toString()

        })
        viewModel.getDataStartup(id)
        viewModel.startupResponse.observe(this,{
            binding.startupcontentname.text = it.name.toString()
            binding.tvDetailAboutStartup.text = it.description.toString()

        })
        binding.cardviewAddressstartup.setOnClickListener{
            // TODO: 11/29/2021
        }
        binding.buttonFundNow.setOnClickListener {
            startActivity(Intent(this,PaymentActivity::class.java))
        }
    }
}