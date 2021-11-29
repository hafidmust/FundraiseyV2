package app.binar.synrgy.android.finalproject.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityPaymentBinding


class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.button1000k.setOnClickListener{
            binding.button1000k.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_primary))
        }
        binding.buttonPay.setOnClickListener {
            startActivity(Intent(this,DetailPaymentActivity::class.java))
        }
    }
}