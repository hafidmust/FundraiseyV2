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
        showShimmer()
        val id = intent.getIntExtra(GET_ID,0)
        Log.d("id",id.toString())
        viewModel = ViewModelProvider(this).get(LoanDetailsViewModel::class.java)
        viewModel.getDataFromAPI(id)

        viewModel.loanResponse.observe(this,{
            hideShimmer()


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
            when(it.paymentPlan?.totalPeriod){
                1 -> {
                    binding.contentreturn.text = "Cash Payment"
                }
                2 -> {
                    binding.contentreturn.text = "1 years installment"
                }
                4 -> {
                    binding.contentreturn.text = "6 month installment"
                }
            }

        })
        binding.nested.visibility = View.VISIBLE

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
//            startActivity(Intent(this,PaymentActivity::class.java))
            val intentSendLoanId = Intent(this, PaymentActivity::class.java).apply {
                putExtra(PaymentActivity.GET_LOAN_ID, id)
            }
            startActivity(intentSendLoanId)
        }
    }

    private fun hideShimmer() {
        binding.shimmerprojectfunding.stopShimmerAnimation()
        binding.shimmerprojectfunding.visibility = View.GONE
        binding.shimmernominal.stopShimmerAnimation()
        binding.shimmernominal.visibility = View.GONE
        binding.shimmerremaining.stopShimmerAnimation()
        binding.shimmerremaining.visibility = View.GONE
        binding.shimmerprogres.stopShimmerAnimation()
        binding.shimmerprogres.visibility = View.GONE
        binding.shimmerdonor.stopShimmerAnimation()
        binding.shimmerdonor.visibility = View.GONE
        binding.shimmerstartupt.stopShimmerAnimation()
        binding.shimmerstartupt.visibility = View.GONE
        binding.shimmerlogo.stopShimmerAnimation()
        binding.shimmerlogo.visibility = View.GONE
        binding.shimmerloanapp.stopShimmerAnimation()
        binding.shimmerloanapp.visibility = View.GONE
        binding.shimmercontentabout.stopShimmerAnimation()
        binding.shimmercontentabout.visibility = View.GONE
        binding.shimmernamestart.stopShimmerAnimation()
        binding.shimmernamestart.visibility = View.GONE
    }

    private fun showShimmer() {
        binding.shimmerprojectfunding.startShimmerAnimation()
        binding.shimmernominal.startShimmerAnimation()
        binding.shimmerremaining.startShimmerAnimation()
        binding.shimmerdonor.startShimmerAnimation()
        binding.shimmerprogres.startShimmerAnimation()
        binding.shimmerlogo.startShimmerAnimation()
        binding.shimmerloanapp.startShimmerAnimation()
        binding.shimmercontentabout.startShimmerAnimation()
        binding.shimmerstartupt.startShimmerAnimation()
        binding.shimmernamestart.startShimmerAnimation()
    }
}