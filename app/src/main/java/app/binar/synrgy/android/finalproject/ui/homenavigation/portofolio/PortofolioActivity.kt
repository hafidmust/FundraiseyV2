package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding
import app.binar.synrgy.android.finalproject.model.PortofolioModel
import app.binar.synrgy.android.finalproject.ui.loan.LoanDetailsViewModel

class PortofolioActivity : AppCompatActivity() {

    private lateinit var viewModel: PortofolioViewModel
    private lateinit var binding: FragmentPortofolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_portofolio)
        binding = FragmentPortofolioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val portofolioAdapter = AdapterPortofolio(listOf(),
        object : AdapterPortofolio.EventListener {
            override fun click(item: PortofolioModel) {

            }
        })
        binding.recyclerPortofolio.adapter = portofolioAdapter
        viewModel = ViewModelProvider(this).get(PortofolioViewModel::class.java)
        viewModel.onViewLoaded()

    }
}