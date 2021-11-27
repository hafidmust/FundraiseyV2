package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding

class PortofolioActivity : AppCompatActivity() {

    private lateinit var viewModel: PortofolioViewModel
    private lateinit var binding: FragmentPortofolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        binding = FragmentPortofolioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }
}