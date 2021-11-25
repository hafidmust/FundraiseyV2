package app.binar.synrgy.android.finalproject.ui.loan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityLoanDetailsBinding

class LoanDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoanDetailsBinding
    private lateinit var viewModel: LoanDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_details)
        supportActionBar?.hide()

//        viewModel = LoanDetailsViewModel()
//        binding = ActivityLoanDetailsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
    }
}