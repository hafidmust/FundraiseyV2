package app.binar.synrgy.android.finalproject.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

//        var clicked: Boolean
//
//        binding.button1000k.setOnClickListener{
//            clicked = true
//            if (!clicked == true) {
//                binding.button1000k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button1000k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("1000000")
//            }
//            else {
//                binding.button1000k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button1000k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button2000k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button2000k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button2000k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("2000000")
//            }
//            else {
//                binding.button2000k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button2000k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button200k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button200k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button200k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("200000")
//            }
//            else {
//                binding.button200k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button200k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button100k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button100k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button100k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("100000")
//            }
//            else {
//                binding.button100k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button100k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button500k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button500k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button500k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("500000")
//            }
//            else {
//                binding.button500k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button500k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button50k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button50k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button50k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("50000")
//            }
//            else {
//                binding.button50k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button50k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }

        binding.buttonPay.setOnClickListener {
            startActivity(Intent(this,DetailPaymentActivity::class.java))
        }
    }
}