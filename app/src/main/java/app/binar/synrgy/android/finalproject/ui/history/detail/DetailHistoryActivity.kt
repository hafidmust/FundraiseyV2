package app.binar.synrgy.android.finalproject.ui.history.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.HistoryDetailBinding


class DetailHistoryActivity : AppCompatActivity() {
    private lateinit var binding : HistoryDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }
}