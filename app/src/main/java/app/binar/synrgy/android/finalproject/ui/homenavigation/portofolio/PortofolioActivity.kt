package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.data.portofolio.returnInstallment
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding

class PortofolioActivity : AppCompatActivity() {

    private lateinit var viewModel: PortofolioViewModel
    private lateinit var binding: FragmentPortofolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPortofolioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val adapterPortofolio = AdapterPortofolio(listOf(),
            object : AdapterPortofolio.EventListener {
                override fun click(item: loan) {
                }
            })
        binding.recyclerPortofolio.adapter = adapterPortofolio

        viewModel = ViewModelProvider(this).get(PortofolioViewModel::class.java)
        viewModel.getDataLoan()
        viewModel.loanResponse.observe(this,{
            binding.textTotFund.text
        })
        viewModel.getDataInstallment()
        viewModel.installmentResponse.observe(this,{
            binding
        })
    }
}