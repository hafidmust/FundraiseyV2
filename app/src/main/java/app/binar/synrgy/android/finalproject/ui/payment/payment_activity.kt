package app.binar.synrgy.android.finalproject.ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityPaymentBinding

class payment_activity : AppCompatActivity() {

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
    }
}