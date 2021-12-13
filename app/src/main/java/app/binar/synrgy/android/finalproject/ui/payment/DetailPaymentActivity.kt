package app.binar.synrgy.android.finalproject.ui.payment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import app.binar.synrgy.android.finalproject.databinding.ActivityDetailPaymentBinding

import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.ui.payment.dialog.PopupDialog

class DetailPaymentActivity : AppCompatActivity() {
    private lateinit var detailPaymentViewModel: DetailPaymentViewModel
    private lateinit var binding : ActivityDetailPaymentBinding
    private val dialog by lazy { PopupDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        detailPaymentViewModel = DetailPaymentViewModel()

        val adapterPaymentGuide  = AdapterPaymentGuide(listOf())

//        binding.rvGuide.adapter = adapterPaymentGuide
//
//        detailPaymentViewModel.onViewLoaded()
//        detailPaymentViewModel.detailPaymentGuide.observe(this,{
//            adapterPaymentGuide.update(it)
//        })

        binding.copy.setOnClickListener {
            copyVAN()
        }
        binding.btnOtherInvesment.setOnClickListener {
            dialog.showDialog(true)
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,HomeNavigationActivity::class.java))
                finish()
            },5000)
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