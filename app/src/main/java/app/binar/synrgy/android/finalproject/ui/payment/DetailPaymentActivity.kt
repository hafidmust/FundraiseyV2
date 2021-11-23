package app.binar.synrgy.android.finalproject.ui.payment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        binding.copy.setOnClickListener {
            copyVAN()
        }


    }

    private fun copyVAN() {
        val tvToCopy = binding.tvvirtualnumber.text.toString()
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", tvToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(this, "Copied to clipboard",Toast.LENGTH_SHORT).show()
    }
}