package app.binar.synrgy.android.finalproject.ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityDetailPaymentBinding

class DetailPaymentActivity : AppCompatActivity() {
    private lateinit var detailPaymentViewModel: DetailPaymentViewModel
    private lateinit var binding : ActivityDetailPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        detailPaymentViewModel = DetailPaymentViewModel()

        val adapterPaymentGuide  = AdapterPaymentGuide(listOf())

        binding.rvGuide.adapter = adapterPaymentGuide

        detailPaymentViewModel.onViewLoaded()
        detailPaymentViewModel.detailPaymentGuide.observe(this,{
            adapterPaymentGuide.update(it)
        })


    }
}