package app.binar.synrgy.android.finalproject.ui.loan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityLoanDetailsBinding
import app.binar.synrgy.android.finalproject.databinding.DetailLoanBinding

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
//        viewModel = ViewModelProvider(this).get(LoanDetailsViewModel::class.java)
//        viewModel.getDataFromAPI(id)
//        viewModel.loanResponse.observe(this,{
//            binding.textFundingValue.text = it.targetValue.toString()
//            binding.tvStartup.text = it.name
//            binding.textFundingNeeds.text = it.description
//            binding.textFundingAmount.text = it.currentValue.toString()
//        })
    }
}